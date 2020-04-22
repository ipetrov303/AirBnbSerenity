package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class ResultsPage extends BasePage {

    public static final By PRICE_RANGE_BUTTON_LOCATOR = By.id("menuItemButton-price_range");
    public static final By MORE_FILTERS_BUTTON_LOCATOR = By.id("menuItemButton-dynamicMoreFilters");
    public static final By MINIMAL_PRICE_FIELD_LOCATOR = By.id("price_filter_min");
    public static final By MAXIMAL_PRICE_FIELD_LOCATOR = By.id("price_filter_max");
    public static final By PRICE_FILTER_SAVE_BUTTON = By.id("filter-panel-save-button");
    public static final By GRADE_LOCATOR = By.cssSelector("[class='_3zgr580']");
    public static final By GRADE_LOCATOR1 = By.cssSelector("[class='_1bbeetd'] [class='_10fy1f8']");
    public static final By EMPTY_OTHER_FILTERS_LOCATOR = By.cssSelector("[aria-label='Още филтри, 0 филтъра са приложени']");
    public static final By FINAL_PRICE_LOCATOR = By.cssSelector("[class='_1llb8an']");
    public static final By FINAL_PRICE_LOCATOR1 = By.cssSelector("[class='_ebe4pze']");


    @FindBy(css = "[id='filterItem-stepper-min_bathrooms-0'] [aria-label='увеличаване на стойността']")
    public WebElementFacade addBathroomButton;

    @FindBy(className = "_2i58o3a")
    public WebElementFacade submitFiltersButton;

    @FindBy(className = "_8ssblpx")
    public List<WebElementFacade> itemsList;

    @FindBy(className = "_i66xk8d")
    public WebElementFacade nextPageArrowButton;

}
