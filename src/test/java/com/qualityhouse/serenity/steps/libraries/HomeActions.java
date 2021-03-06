package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.qualityhouse.serenity.page_objects.HomePage.DESTINATION_FIELD;
import static com.qualityhouse.serenity.page_objects.HomePage.DESTINATION_SEARCH_OPTIONS;

public class HomeActions extends BaseActions {

    private HomePage homePage;

    @Step
    public void opensHomePage() {
        homePage.open();
    }

    @Step
    public void selectsEURCurrency() {
        clicksOn(homePage.regionAndCurrencyButton);
        clicksOn(homePage.currencyLinkText.get(1));
        clicksOn(homePage.currencyOptions.get(4));
    }

    @Step
    public void searchesForVacationOptions(VacationDetails vacationDetails) throws InterruptedException {
        fillsFieldWithData(DESTINATION_FIELD, vacationDetails.getDestination());
        Thread.sleep(1000);
        selectOptionFromDestinationResults();
        selectCheckInDate(vacationDetails.getDaysFromNow());
        selectCheckOutDate(vacationDetails.getDaysFromNow(), vacationDetails.getPeriodLength());
        clicksOn(homePage.searchBarList.get(2));
        clicksOnIncreaseButton(vacationDetails.getAdults(), homePage.addAdultsButton);
        clicksOnIncreaseButton(vacationDetails.getChildren(), homePage.addChildrenButton);
        clicksOn(homePage.searchButton);

    }


    @Step
    private void selectOptionFromDestinationResults() {
        clicksOn((WebElementFacade) homePage.destinationOptionsDropDown
                .get(0).find(DESTINATION_SEARCH_OPTIONS));
    }


    public void setStartDate(VacationDetails vacationDetails) {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, vacationDetails.getDaysFromNow());
        date = calendar.getTime();

        vacationDetails.setStartDate(formatDate(date));
    }


    public void setEndDate(VacationDetails vacationDetails) {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, vacationDetails.getDaysFromNow() + vacationDetails.getPeriodLength());
        date = calendar.getTime();

        vacationDetails.setEndDate(formatDate(date));
    }
}
