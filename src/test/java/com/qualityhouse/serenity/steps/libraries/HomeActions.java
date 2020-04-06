package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.HomePage;
import net.thucydides.core.annotations.Step;

import static com.qualityhouse.serenity.page_objects.HomePage.*;

public class HomeActions extends BaseActions {

    private HomePage homePage;

    @Step
    public void opensHomePage() {
        homePage.open();
    }

    @Step
    public void submitVacationDetails(VacationDetails vacationDetails) {
        fillsFieldWithData(DESTINATION_FIELD, vacationDetails.getDestination());
        selectOptionFromDestinationResults(0);
        selectStartDate(homePage.checkInDate, vacationDetails.getStartDate());
        selectEndDate(homePage.checkOutDate, vacationDetails.getStartDate(), vacationDetails.getPeriodLength());
        clicksOn(homePage.guestsMenu);
        selectAdults(vacationDetails.getAdults());
        selectChildren(vacationDetails.getChildren());
        clicksOn(homePage.save);
        clicksOn(homePage.searchButton);

    }

    @Step
    private void selectChildren(int numberOfChildren) {
        for (int i = 0; i < numberOfChildren; i++) {
            clicksOn(homePage.guestOptions.get(1).find(GUESTS_PLUS_BUTTONS));
        }
    }
    @Step
    private void selectAdults(int numberOfAdults) {
        for (int i = 0; i < numberOfAdults; i++) {
            clicksOn(homePage.guestOptions.get(0).find(GUESTS_PLUS_BUTTONS));
        }
    }

    @Step
    public void selectOptionFromDestinationResults(int searchResults) {
        clicksOn(homePage.destinationOptionsDropDown.get(searchResults).find(DESTINATION_SEARCH_OPTIONS));
    }
}
