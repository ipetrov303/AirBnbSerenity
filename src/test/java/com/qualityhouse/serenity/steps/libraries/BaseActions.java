package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.BasePage;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.page_objects.utils.ExtrasEnum;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class BaseActions {

    private HomePage homePage;
    private BasePage currentPage;
    private VacationDetails vacationDetails;

    @Step
    protected void clicksOn(WebElementFacade buttonOrLink) {
        buttonOrLink
                .waitUntilClickable()
                .click();
    }

    @Step
    public void clicksOn(final By locator) {
        currentPage.find(locator)
                .waitUntilClickable()
                .click();
    }

    @Step("Enters '{1}' in field {0}")
    protected void fillsFieldWithData(WebElementFacade fieldElement,
                                      String data) {
        if (data != null) {
            fieldElement.waitUntilEnabled()
                    .type(data);
        }
    }

    @Step
    protected void fillsFieldWithData(By fieldElement,
                                      String data) {
        fillsFieldWithData((WebElementFacade) currentPage.find(fieldElement),
                data);
    }

    protected void selectCheckInDate(int daysFromNow) {

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int currentMonthNow = calendar.get(Calendar.MONTH);

        calendar.add(Calendar.DAY_OF_MONTH, daysFromNow);

        int numberOfClicks = calendar.get(Calendar.MONTH) - currentMonthNow;

        if (numberOfClicks != 0) {
            for (int i = 0; i < numberOfClicks; i++) {
                clicksOn(homePage.monthRightArrow);
            }
        }

        List<WebElementFacade> options = homePage.checkOutDate.get(0).thenFindAll(By.tagName("td"));

        for (WebElementFacade option : options) {
            if (option.getText().equals(calendar.get(Calendar.DAY_OF_MONTH) + "")) {
                option.click();
                break;
            }
        }
    }

    protected void selectCheckOutDate(int daysFromNow, int vacationLength) {

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(Calendar.DAY_OF_MONTH, daysFromNow);

        int monthFromReservation = calendar.get(Calendar.MONTH);
        calendar.add(Calendar.DAY_OF_MONTH, vacationLength);

        int numberOfClicks = calendar.get(Calendar.MONTH) - monthFromReservation;

        if (numberOfClicks != 0) {
            for (int i = 0; i < numberOfClicks; i++) {
                clicksOn(homePage.monthRightArrow);
            }
        }

        List<WebElementFacade> options = homePage.checkOutDate.get(0).thenFindAll(By.tagName("td"));

        for (WebElementFacade option : options) {
            if (option.getText().equals(calendar.get(Calendar.DAY_OF_MONTH) + "")) {
                option.click();
                break;
            }
        }
    }


    @Step
    protected void clicksOnIncreaseButton(int numbersOfClicks, WebElementFacade plusButton) {
        for (int i = 0; i < numbersOfClicks; i++) {
            plusButton.waitUntilClickable()
                    .click();
        }
    }

    @Step
    protected void clicksMultipleOptions(List<String> listOfExtras) {
        for (String extra : listOfExtras) {
            clicksOn(By.cssSelector(ExtrasEnum.valueOf(extra.toUpperCase()).getValue()));
        }
    }
}
