package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.qualityhouse.serenity.page_objects.ReservationDetailsPage.*;


public class ReservationDetailsActions extends BaseActions {
    ReservationDetailsPage currentPage;


    @Step
    public int readsNumberOfPeopleAsInteger(By locator) {
        return Integer.parseInt(readsTextFrom(locator).trim().substring(0, 1));
    }

    public int getExpectedTotalPrice(VacationDetails vacationDetails) {
        return vacationDetails.getFinalPrice();
    }

    public int getActualTotalPrice() {
        if (!currentPage.findAll(BOOKING_WIDGET_LOCATOR).isEmpty()) {
            return readsPrice(FINAL_PRICE1);
        } else {
            return readsPrice(FINAL_PRICE);
        }
    }

    public int getActualNumberOfNights() {
        List<String> data;
        if (!currentPage.findAll(BOOKING_WIDGET_LOCATOR).isEmpty()) {
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
        if (!currentPage.findAll(BOOKING_WIDGET_LOCATOR).isEmpty()) {
            return readsPrice(NUMBER_OF_PEOPLE1);
        } else {
            return readsPrice(NUMBER_OF_PEOPLE);
        }
    }
}
