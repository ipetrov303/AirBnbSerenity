package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import com.qualityhouse.serenity.steps.libraries.ReservationDetailsActions;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.qualityhouse.serenity.page_objects.ReservationDetailsPage.*;

public class ReservationDetailsStepsDefinitions {

    @Steps
    private ReservationDetailsActions bob;
    private ReservationDetailsPage reservationDetails;
    private VacationDetails vacationDetails;


    @Then("^the booking details are displayed correctly$")
    public void correctDetailsAreDisplayed() {
        String pattern = "(\\d+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher;
        List<Integer> valuesForUnitPriceAndNumberOfDays = new ArrayList<>();

        int taxForService;
        int finalPrice;
        int actualNumberOfPeople;
        int weeklyDiscount;
        boolean isPresent = reservationDetails.getDriver().findElements(BOOKING_WIDGET_LOCATOR).isEmpty();

        if (!isPresent) {
            taxForService = bob.readsPrice(TAX_FOR_SERVICE1);
            finalPrice = bob.readsPrice(FINAL_PRICE1);
            actualNumberOfPeople = bob.readsNumberOfPeopleAsInteger(NUMBER_OF_PEOPLE1);
            matcher = regex.matcher(bob.readsTextFrom(PRICE_MULTIPLY_NIGHTS_TEXT_LOCATOR1));
            weeklyDiscount = Integer.parseInt(bob.readsTextFrom(WEEKLY_DISCOUNT_FIELD_LOCATOR1).substring(2));
        } else {
            taxForService = bob.readsPrice(TAX_FOR_SERVICE);
            finalPrice = bob.readsPrice(FINAL_PRICE);
            actualNumberOfPeople = bob.readsNumberOfPeopleAsInteger(NUMBER_OF_PEOPLE);
            matcher = regex.matcher(bob.readsTextFrom(PRICE_MULTIPLY_NIGHTS_TEXT_LOCATOR));
            weeklyDiscount = Integer.parseInt(bob.readsTextFrom(WEEKLY_DISCOUNT_FIELD_LOCATOR).substring(2));
        }

        while (matcher.find()) {
            valuesForUnitPriceAndNumberOfDays.add(Integer.parseInt(matcher.group() + ""));
        }

        int pricePerNight = valuesForUnitPriceAndNumberOfDays.get(0);
        int numberOfNights = valuesForUnitPriceAndNumberOfDays.get(1);


        SoftAssertions softly = new SoftAssertions();

        int expectedTotalPrice = ((pricePerNight * numberOfNights) + taxForService) - weeklyDiscount;
        int expectedNumberOfGuests = HomeStepsDefinitions.vacationDetails.getAdults()
                + HomeStepsDefinitions.vacationDetails.getChildren();

        softly.assertThat(numberOfNights)
                .as("Number of nights should be displayed correctly: ")
                .isEqualTo(HomeStepsDefinitions.vacationDetails.getPeriodLength());

        softly.assertThat(actualNumberOfPeople)
                .as("Number of guests displayed correctly: ")
                .isEqualTo(expectedNumberOfGuests);

        softly.assertThat(finalPrice)
                .as("Final price should be calculated correctly: ")
                .isEqualTo(expectedTotalPrice);

        softly.assertAll();
    }
}
