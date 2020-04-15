package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;


public class ReservationDetailsActions extends BaseActions {
    ReservationDetailsPage currentPage;

    /*@Step
    public int readsPriceForTaxService() {
        int result = 0;
        try {
            result = Integer.parseInt(readsTextFrom(TAX_FOR_SERVICE).substring(1));
        } catch (
                RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

        if (result == 0) {
            try {
                result = Integer.parseInt(readsTextFrom(TAX_FOR_SERVICE1).substring(1));
            } catch (
                    RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return result;
    }

    @Step
    public int readsFinalPrice() {
        int result = 0;
        try {
            result = Integer.parseInt(readsTextFrom(FINAL_PRICE).substring(1));
        } catch (
                RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

        if (result == 0) {
            try {
                result = Integer.parseInt(readsTextFrom(FINAL_PRICE1).substring(1));
            } catch (
                    RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return result;
    }

    @Step
    public int readsNumberOfPeopleAsInteger() {
        int result = 0;
        try {
            result = Integer.parseInt(readsTextFrom(NUMBER_OF_PEOPLE).substring(0, 1));
        } catch (
                RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

        if (result == 0) {
            try {
                result = Integer.parseInt(readsTextFrom(NUMBER_OF_PEOPLE1).substring(0, 1));
            } catch (
                    RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return result;
    }

    @Step
    public String readsTextFrom() {
        String result = "";
        try {
            result = readsTextFrom((WebElementFacade) currentPage.find(PRICE_MULTIPLY_NIGHTS_TEXT_LOCATOR));
        } catch (
                RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

        if (result.isEmpty()) {
            try {
                result = readsTextFrom((WebElementFacade) currentPage.find(PRICE_MULTIPLY_NIGHTS_TEXT_LOCATOR1));
            } catch (
                    RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return result;
    }

    public int readsWeeklyDiscount() {
        int result = 0;
        try {
            result = Integer.parseInt(readsTextFrom(WEEKLY_DISCOUNT_FIELD_LOCATOR).substring(2));
        } catch (
                RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

        if (result == 0) {
            try {
                result = Integer.parseInt(readsTextFrom(WEEKLY_DISCOUNT_FIELD_LOCATOR1).substring(2));
            } catch (
                    RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return result;
    }*/

    @Step
    public int readsNumberOfPeopleAsInteger(By locator) {
        return Integer.parseInt(readsTextFrom(locator).trim().substring(0, 1));
    }
}
