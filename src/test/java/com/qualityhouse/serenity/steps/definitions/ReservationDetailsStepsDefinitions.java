package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import com.qualityhouse.serenity.steps.libraries.ReservationDetailsActions;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.NoSuchElementException;

import static com.qualityhouse.serenity.page_objects.ReservationDetailsPage.*;

public class ReservationDetailsStepsDefinitions {

    @Steps
    private ReservationDetailsActions bob;
    private ReservationDetailsPage details;

    @Then("^correct total price and reservation details are displayed$")
    public void correctDetailsAreDisplayed() {

        int dailyPrice = 0;
        int taxForService = 0;
        int finalPrice = 0;

        try {
           dailyPrice = bob.readsPrice(DAILY_PRICE_FOR_ONE_DAY);
           taxForService = bob.readsPrice(TAX_FOR_SERVICE);
           finalPrice = bob.readsPrice(TOTAL_PRICE);
        }catch (NoSuchElementException exception ) {

            System.out.println("Next locators batch:");
        }

        if(dailyPrice == 0 ) {
            try {
                dailyPrice = bob.readsPrice(DAILY_PRICE_FOR_ONE_DAY1);
                taxForService = bob.readsPrice(TAX_FOR_SERVICE1);
                finalPrice = bob.readsPrice(TOTAL_PRICE1);
            } catch (NoSuchElementException exception) {
                System.out.println(exception.getMessage());
            }
        }

        SoftAssertions softly = new SoftAssertions();

        int expectedTotalPrice = dailyPrice * 3 + taxForService;

        softly.assertThat(finalPrice).isEqualTo(expectedTotalPrice);
       // System.out.println(bob.readsPrice(DAILY_PRICE_FOR_ONE_DAY));
        //System.out.println(bob.readsPrice(TOTAL_PRICE));
    }
}
