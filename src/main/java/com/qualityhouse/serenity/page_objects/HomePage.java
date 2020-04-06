package com.qualityhouse.serenity.page_objects;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://www.airbnb.com/?_set_bev_on_new_domain=1585921791_MDJiOTdkOWMwOGQz&locale=en")
public class HomePage extends PageObject {

    public static final By DESTINATION_FIELD = By.name("query");
    public static final By GUESTS_PLUS_BUTTONS = By.className("_1iz654np");
    public static final By DESTINATION_SEARCH_OPTIONS = By.className("_121z06r2");

    @FindBy(css = "._1lds9wb" )
    public WebElementFacade checkInDate;

    @FindBy (css = "._1lds9wb")
    public WebElementFacade checkOutDate;

    @FindBy(id = "lp-guestpicker")
    public WebElementFacade guestsMenu;

    @FindBy(className = "_1a72ixey")
    public List<WebElementFacade> guestOptions;

    @FindBy(className = "_1vs0x720")
    public WebElementFacade searchButton;

    @FindBy(className = "_b0ybw8s")
    public WebElementFacade save;

    @FindBy(className = "_1avdemu")
    public List<WebElementFacade> destinationOptionsDropDown;
}

