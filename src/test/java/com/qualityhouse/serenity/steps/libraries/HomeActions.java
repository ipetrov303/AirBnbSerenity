package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import static com.qualityhouse.serenity.page_objects.HomePage.DESTINATION_FIELD;
import static com.qualityhouse.serenity.page_objects.HomePage.DESTINATION_SEARCH_OPTIONS;

public class HomeActions extends BaseActions {

    private HomePage homePage;

    @Step
    public void opensHomePage() {
        homePage.open();
    }

    @Step
    public void selectsCurrency() {
        clicksOn(homePage.regionAndCurrencyButton);
        clicksOn(homePage.currencyLinkText.get(1));
        clicksOn(homePage.currencyOptions.get(4));
    }

    @Step
    public void submitVacationDetails(VacationDetails vacationDetails) {
        fillsFieldWithData(DESTINATION_FIELD, vacationDetails.getDestination());
        selectOptionFromDestinationResults(0);
        selectStartDate(homePage.checkInDate, vacationDetails.getDaysFromNow());
        selectEndDate(homePage.checkOutDate, (vacationDetails.getDaysFromNow() + vacationDetails.getPeriodLength()));
        clicksOn(homePage.guestsMenu);
        clicksOnIncreaseButton(vacationDetails.getAdults(), homePage.addAdultsButton);
        clicksOnIncreaseButton(vacationDetails.getChildren(), homePage.addChildrenButton);
        clicksOn(homePage.saveLinkText);
        clicksOn(homePage.searchButton);

    }


    @Step
    private void selectOptionFromDestinationResults(int searchResults) {
        clicksOn((WebElementFacade) homePage.destinationOptionsDropDown.get(searchResults).find(DESTINATION_SEARCH_OPTIONS));
    }


}
