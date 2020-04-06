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
        selectDate(homePage.checkInDate, 5);
        selectDate(homePage.checkOutDate, 11);
        clicksOn(homePage.guestsMenu);
        selectGuests(0);
        selectGuests(0);
        selectGuests(1);
        clicksOn(homePage.save);
        clicksOn(homePage.searchButton);

    }

    @Step
    public void selectOptionFromDestinationResults(int searchResults) {
        clicksOn(homePage.destinationOptionsDropDown.get(searchResults).find(DESTINATION_SEARCH_OPTIONS));
    }

    @Step
    public void selectGuests(int numberAndTypeOfGuests) {
        clicksOn(homePage.guestOptions.get(numberAndTypeOfGuests).find(GUESTS_PLUS_BUTTONS));
    }

}
