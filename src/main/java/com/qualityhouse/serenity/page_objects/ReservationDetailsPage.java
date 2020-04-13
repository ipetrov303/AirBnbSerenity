package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ReservationDetailsPage extends PageObject {

    public static final By DAILY_PRICE_FOR_ONE_DAY = By.cssSelector("[class='_1p0spma2'] [class='_doc79r']");
    public static final By TAX_FOR_SERVICE = By.cssSelector("#book_it_form > div:nth-child(3) > div:nth-child(3) > div._hgs47m > div._ni9axhe > span > span");
    public static final By TOTAL_PRICE = By.cssSelector("[class='_121z06r2'] [class='_j1kt73']");
    public static final By NUMBER_OF_PEOPLE = By.cssSelector("[class='guest-label__text guest-label__text-guests']");

    public static final By DAILY_PRICE_FOR_ONE_DAY1 = By.cssSelector("[class='_ymq6as'] [class='_pgfqnw']");
    public static final By TAX_FOR_SERVICE1 = By.cssSelector("#site-content > div > div._1sgnm05 > div > div > div._ktx4dc > div > div > div:nth-child(1) > div > div > div > div._1cvivhm > div > ul._1hvzytt > li._adhikmk > span._ra05uc");
    public static final By TOTAL_PRICE1 = By.cssSelector("[class='_1d3ext9m']");
    public static final By NUMBER_OF_PEOPLE1 = By.cssSelector("[class = '_1ir6ymk'] span");


    public static final By NUMBER_OF_DAYS = By.cssSelector("[class='_10ejfg4u'] [class='_1jlnvra2'] span");

    @FindBy(css = "[class='_hgs47m'] [class='_1jlnvra2'] span")
    public WebElementFacade priceMultiplyNightsText;

    @FindBy(css = "[class='_15osndh6'] div")
    public WebElementFacade weeklyDiscountField;
}
