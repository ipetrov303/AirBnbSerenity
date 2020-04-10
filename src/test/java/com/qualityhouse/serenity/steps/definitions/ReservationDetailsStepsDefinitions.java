package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import com.qualityhouse.serenity.steps.libraries.ReservationDetailsActions;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import static com.qualityhouse.serenity.page_objects.ReservationDetailsPage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ReservationDetailsStepsDefinitions {

    @Steps
    private ReservationDetailsActions bob;
    private ReservationDetailsPage details;

    @Then("^correct total price and reservation details are displayed$")
    public void correctDetailsAreDisplayed() {

        int dailyPrice = 0;
        int taxForService = 0;
        int finalPrice = 0;
        int numberOfPeople = 0;

        try {
           dailyPrice = bob.readsPrice(DAILY_PRICE_FOR_ONE_DAY);
           taxForService = bob.readsPrice(TAX_FOR_SERVICE);
           finalPrice = bob.readsPrice(TOTAL_PRICE);
           numberOfPeople = bob.readsNumberOfPeopleAsInteger(NUMBER_OF_PEOPLE);

            if(dailyPrice == 0 ) {
                dailyPrice = bob.readsPrice(DAILY_PRICE_FOR_ONE_DAY1);
                taxForService = bob.readsPrice(TAX_FOR_SERVICE1);
                finalPrice = bob.readsPrice(TOTAL_PRICE1);
                numberOfPeople = bob.readsNumberOfPeopleAsInteger(NUMBER_OF_PEOPLE1);
            }

        }catch (RuntimeException exception ) {
            System.out.println(exception.getMessage());
        }



        SoftAssertions softly = new SoftAssertions();

        int expectedTotalPrice = (dailyPrice * numberOfPeople) + taxForService;

        softly.assertThat(finalPrice).as("dawdwa").isEqualTo(expectedTotalPrice);

        softly.assertAll();
       // System.out.println(bob.readsPrice(DAILY_PRICE_FOR_ONE_DAY));
        //System.out.println(bob.readsPrice(TOTAL_PRICE));
    }
}
