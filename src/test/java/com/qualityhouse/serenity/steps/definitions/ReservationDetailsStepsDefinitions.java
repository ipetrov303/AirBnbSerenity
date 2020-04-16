package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import com.qualityhouse.serenity.steps.libraries.ReservationDetailsActions;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

public class ReservationDetailsStepsDefinitions {

    @Steps
    private ReservationDetailsActions bob;
    private ReservationDetailsPage reservationDetails;
    private VacationDetails vacationDetails;


    @Then("^the booking details are displayed correctly$")
    public void correctDetailsAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(bob.getActualNumberOfNights())
                .as("Number of nights should be displayed correctly: ")
                .isEqualTo(HomeStepsDefinitions.vacationDetails.getPeriodLength());

        softly.assertThat(bob.getActualNumberOfPeople())
                .as("Number of guests displayed correctly: ")
                .isEqualTo(HomeStepsDefinitions.vacationDetails.getAllNumberOfPersons());

        softly.assertThat(bob.getActualTotalPrice())
                .as("Final price should be calculated correctly: ")
                .isEqualTo(HomeStepsDefinitions.vacationDetails.getFinalPrice());

        softly.assertAll();
    }
}
