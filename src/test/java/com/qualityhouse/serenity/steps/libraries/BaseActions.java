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

    protected void selectStartDate(WebElementFacade webElement, int startDate) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        String currentDate = Integer.toString((calendar.get(Calendar.DATE) + startDate));

        List<WebElementFacade> options = webElement.thenFindAll(By.tagName("td"));

        for (WebElementFacade option : options) {
            if (option.getText().equals(currentDate)) {
                option.click();
                break;
            }
        }
    }

    protected void selectEndDate(WebElementFacade webElement, int periodLength) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        String currentDate = Integer.toString((calendar.get(Calendar.DATE) + periodLength));

        List<WebElementFacade> options = webElement.thenFindAll(By.tagName("td"));

        for (WebElementFacade option : options) {
            if (option.getText().equals(currentDate)) {
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
