package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import com.qualityhouse.serenity.steps.libraries.ReservationDetailsActions;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import static com.qualityhouse.serenity.page_objects.BasePage.vacationDetails;

public class ReservationDetailsStepsDefinitions {

    @Steps
    private ReservationDetailsActions bob;
    private ReservationDetailsPage reservationDetails;

    @Then("^the booking details are displayed correctly$")
    public void correctDetailsAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(bob.getStartDate())
                .as("Start date should be displayed correctly: ")
                .isEqualTo(vacationDetails.getStartDate());

        softly.assertThat(bob.getEndDate())
                .as("End date should be displayed correctly: ")
                .isEqualTo(vacationDetails.getEndDate());

        softly.assertThat(bob.getActualNumberOfPeople())
                .as("Number of guests displayed correctly: ")
                .isEqualTo(vacationDetails.getAllNumberOfPersons());

        softly.assertThat(bob.getActualTotalPrice())
                .as("Final price should be calculated correctly: ")
                .isEqualTo(vacationDetails.getFinalPrice());

        softly.assertAll();
    }
}
