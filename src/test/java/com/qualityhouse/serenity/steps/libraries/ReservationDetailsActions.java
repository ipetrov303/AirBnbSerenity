package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.qualityhouse.serenity.page_objects.ReservationDetailsPage.*;


public class ReservationDetailsActions extends BaseActions {

    private ReservationDetailsPage currentPage;

    @Step
    public int readsNumberOfPeopleAsInteger(By locator) {
        return Integer.parseInt(readsTextFrom(locator).trim().substring(0, 1));
    }


    public int getActualTotalPrice() {
        return isSiteVersionOneLoaded(BOOKING_WIDGET_LOCATOR) ?
               readsPrice(FINAL_PRICE1_LOCATOR1) :
               readsPrice(FINAL_PRICE_LOCATOR);
    }

    public int getActualNumberOfNights() {
        List<String> data;
        if (isSiteVersionOneLoaded(BOOKING_WIDGET_LOCATOR)) {
            data = Arrays.stream(readsTextFrom(PRICE_MULTIPLY_NIGHTS_TEXT_LOCATOR1)
                    .split(" "))
                    .collect(Collectors.toList());
        } else {
            data = Arrays.stream(readsTextFrom(PRICE_MULTIPLY_NIGHTS_TEXT_LOCATOR)
                    .split(" "))
                    .collect(Collectors.toList());
        }
        return Integer.parseInt(data.get(data.size() - 2));
    }


    public int getActualNumberOfPeople() {
        return isSiteVersionOneLoaded(BOOKING_WIDGET_LOCATOR) ?
               readsPrice(NUMBER_OF_PEOPLE1) :
               readsPrice(NUMBER_OF_PEOPLE);
    }


    public String getStartDate() {
        return isSiteVersionOneLoaded(BOOKING_WIDGET_LOCATOR) ?
               readsTextFrom(START_DATE_LOCATOR1).trim() :
               formatDate(readsValue(START_DATE_LOCATOR));
    }

    public String getEndDate() {
        return isSiteVersionOneLoaded(BOOKING_WIDGET_LOCATOR) ?
               readsTextFrom(END_DATE_LOCATOR1).trim() :
               formatDate(readsValue(END_DATE_LOCATOR));
    }
}
