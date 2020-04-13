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
    @Steps
    private ReservationDetailsPage reservationDetails;
    @Steps
    private VacationDetails vacationDetails;


    @Then("^correct total price and reservation details are displayed$")
    public void correctDetailsAreDisplayed() {

        int taxForService = 0;
        int finalPrice = 0;
        int actualNumberOfPeople = 0;

        try {
            taxForService = bob.readsPrice(TAX_FOR_SERVICE);
            finalPrice = bob.readsPrice(TOTAL_PRICE);
            actualNumberOfPeople = bob.readsNumberOfPeopleAsInteger(NUMBER_OF_PEOPLE);

            if (taxForService == 0) {
                taxForService = bob.readsPrice(TAX_FOR_SERVICE1);
                finalPrice = bob.readsPrice(TOTAL_PRICE1);
                actualNumberOfPeople = bob.readsNumberOfPeopleAsInteger(NUMBER_OF_PEOPLE1);
            }

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }


        String pattern = "(\\d+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(bob.readsTextFrom(reservationDetails.priceMultiplyNightsText));
        List<Integer> valuesForUnitPriceAndNumberOfDays= new ArrayList<>();

        while (matcher.find()) {
            valuesForUnitPriceAndNumberOfDays.add(Integer.parseInt(matcher.group() + ""));
        }

        int pricePerNight = valuesForUnitPriceAndNumberOfDays.get(0);
        int numberOfNights = valuesForUnitPriceAndNumberOfDays.get(1);
        int weeklyDiscount = Integer.parseInt(reservationDetails.weeklyDiscountField.getText().substring(2));


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
