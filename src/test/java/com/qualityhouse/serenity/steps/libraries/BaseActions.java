package com.qualityhouse.serenity.steps.libraries;


import com.qualityhouse.serenity.page_objects.BasePage;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.page_objects.utils.ExtrasEnum;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.qualityhouse.serenity.page_objects.ReservationDetailsPage.BOOKING_WIDGET_LOCATOR;

public class BaseActions {

    private HomePage homePage;
    private BasePage currentPage;

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

    @Step
    public String readsTextFrom(WebElementFacade webElement) {
        return webElement.waitUntilVisible()
                .getText()
                .trim();
    }

    @Step
    public String readsTextFrom(By locator) {
        return readsTextFrom((WebElementFacade) currentPage.find(locator));
    }

    @Step
    public void switchesToOfferTab() {
        String mainWindow = currentPage.getDriver()
                .getWindowHandle();

        waitForTheSecondTab();

        Set<String> windowsHandles = currentPage.getDriver()
                .getWindowHandles();

        String tabToSwitch = windowsHandles.toArray()[1].toString();

        currentPage.getDriver().switchTo().window(tabToSwitch);
    }

    private void waitForTheSecondTab() {
        int attempt = 0;
        while (currentPage.getDriver().getWindowHandles().size() < 2) {
            attempt++;

            if (attempt > 100) {
                throw new RuntimeException("Cannot switch to tab because there aren't any!");
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Step
    public double readsDoubleFrom(By locator) {
        String numericText = readsTextFrom((WebElementFacade) currentPage.find(locator));
        NumberFormat number = NumberFormat.getCurrencyInstance(Locale.GERMANY);

        try {
            return number.parse(numericText).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't convert " + numericText + " to Double!");
        }
    }

    @Step
    public int readsPrice(By locator) {
        return Integer.parseInt(readsTextFrom(locator).replaceAll("[^0-9]+", ""));
    }

    @Step
    public int readsPrice(WebElementFacade webElement) {
        return Integer.parseInt(readsTextFrom(webElement).replaceAll("[^0-9]+", ""));
    }

    @Step
    public int readsNumberOfPeopleAsInteger(By locator) {
        return Integer.parseInt(readsTextFrom(locator).trim().substring(0, 1));
    }

    public String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return format.format(date);
    }

    public String formatDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return format.format(date);
    }

    public String readsValue(By locator) {
        return currentPage.find(locator).getValue().trim();
    }


    public boolean isSiteVersionOneLoaded(By locator) {
        return !currentPage.findAll(locator).isEmpty();
    }

}
