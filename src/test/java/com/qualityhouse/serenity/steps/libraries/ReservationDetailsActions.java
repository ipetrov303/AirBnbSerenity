package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.ReservationDetailsPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;


public class ReservationDetailsActions extends BaseActions {
    ReservationDetailsPage currentPage;

    @Step
    public int readsNumberOfPeopleAsInteger(By locator) {
        return Integer.parseInt(readsTextFrom(locator).trim().substring(0, 1));
    }
}
