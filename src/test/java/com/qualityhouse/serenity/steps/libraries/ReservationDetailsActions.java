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

    @Step
    public int getActualTotalPrice() {
        if (hasVersion1()) {
            return readsPrice(FINAL_PRICE1);
        } else {
            return readsPrice(FINAL_PRICE);
        }
    }

    @Step
    public int getActualNumberOfNights() {
        List<String> data;
        if (hasVersion1()) {
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

    @Step
    public int getActualNumberOfPeople() {
        if (hasVersion1()) {
            return readsPrice(NUMBER_OF_PEOPLE1);
        } else {
            return readsPrice(NUMBER_OF_PEOPLE);
        }
    }

    private boolean hasVersion1() {
        return !currentPage.findAll(BOOKING_WIDGET_LOCATOR).isEmpty();
    }
}
