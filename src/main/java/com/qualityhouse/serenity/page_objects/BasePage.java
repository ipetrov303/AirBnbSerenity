package com.qualityhouse.serenity.page_objects;

import com.qualityhouse.serenity.entities.VacationDetails;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class BasePage extends PageObject {
    @Steps
    public static VacationDetails vacationDetails;
}
