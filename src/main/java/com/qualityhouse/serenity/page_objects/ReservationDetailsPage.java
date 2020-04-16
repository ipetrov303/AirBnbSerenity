package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ReservationDetailsPage extends PageObject {

    public static final By TAX_FOR_SERVICE = By.cssSelector("#book_it_form > div:nth-child(3) > div:nth-child(3) > div._hgs47m > div._ni9axhe > span > span");
    public static final By FINAL_PRICE = By.cssSelector("[class='_121z06r2'] [class='_j1kt73']");
    public static final By NUMBER_OF_PEOPLE = By.cssSelector("[class='guest-label__text guest-label__text-guests']");
    public static final By PRICE_MULTIPLY_NIGHTS_TEXT_LOCATOR = By.cssSelector("[class='_hgs47m'] [class='_1jlnvra2'] span");
    public static final By WEEKLY_DISCOUNT_FIELD_LOCATOR = By.cssSelector("#book_it_form > div:nth-child(3) > div:nth-child(2) > div._hgs47m > div._ni9axhe > span > span > div");

    public static final By TAX_FOR_SERVICE1 = By.cssSelector("[class='_adhikmk'] [class='_ra05uc']");
    public static final By FINAL_PRICE1 = By.cssSelector("[class='_1d3ext9m']");
    public static final By NUMBER_OF_PEOPLE1 = By.cssSelector("[class = '_1ir6ymk'] span");
    public static final By PRICE_MULTIPLY_NIGHTS_TEXT_LOCATOR1 = By.cssSelector("[class='_8zqgja']");
    public static final By WEEKLY_DISCOUNT_FIELD_LOCATOR1 = By.cssSelector("[class='_l1ngr4']");

    public static final By BOOKING_WIDGET_LOCATOR = By.cssSelector("[data-plugin-in-point-id='BOOK_IT_SIDEBAR']");
}
