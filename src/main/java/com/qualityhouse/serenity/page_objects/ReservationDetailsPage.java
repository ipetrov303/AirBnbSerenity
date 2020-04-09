package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ReservationDetailsPage extends PageObject{

    public static final By DAILY_PRICE_FOR_ONE_PERSON = By.className("_doc79r");
    public static final By TAX_FOR_SERVICE = By.className("_j1kt73");
    public static final By TOTAL_PRICE = By.className("_j1kt73");

    @FindBy(className = "_doc79r")
    public WebElementFacade dailyPrice;
}
