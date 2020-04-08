package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import com.qualityhouse.serenity.steps.libraries.ReservationDetailsActions;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import static com.qualityhouse.serenity.page_objects.ReservationDetailsPage.*;

public class ReservationDetailsStepsDefinitions {

    @Steps
    private ReservationDetailsActions bob;
    private ReservationDetailsPage details;

    @Then("^correct total price and reservation details are displayed$")
    public void correctDetailsAreDisplayed() {

        SoftAssertions softly = new SoftAssertions();

        double expectedTotalPrice = bob.readsPrice(DAILY_PRICE_FOR_ONE_PERSON) * 3 + bob.readsPrice(TAX_FOR_SERVICE);

        softly.assertThat(bob.readsPrice(TOTAL_PRICE)).isEqualTo(expectedTotalPrice);
        System.out.println(bob.readsPrice(DAILY_PRICE_FOR_ONE_PERSON));
        System.out.println(bob.readsPrice(TOTAL_PRICE));
    }
}
