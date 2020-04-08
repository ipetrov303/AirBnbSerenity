package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.ResultsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

import static com.qualityhouse.serenity.page_objects.ResultsPage.*;


public class ResultsPageActions extends BaseActions {

    ResultsPage resultsPage;

    @Step
    public void selectFilters(VacationDetails details) {

        clicksOn(PRICE_RANGE_BUTTON_LOCATOR);
        fillsFieldWithData(MINIMAL_PRICE_FIELD_LOCATOR, details.getPriceFrom());
        fillsFieldWithData(MAXIMAL_PRICE_FIELD_LOCATOR, details.getPriceTo());
        clicksOn(PRICE_FILTER_SAVE_BUTTON);
        clicksOn(MORE_FILTERS_BUTTON_LOCATOR);
        clicksOnIncreaseButton(details.getBathrooms(), resultsPage.addBathroomButton);
        clicksMultipleOptions(Arrays.asList(details.getExtras().split(", ")));
        clicksOn(resultsPage.submitFiltersButton);
    }

    @Step
    public void clicksOnFirstResultWithGradeFiveOrAbove() {

        List<WebElementFacade> grades = resultsPage.gradesList;
        for (int i = 0; i < grades.size(); i++) {
            if ( Double.parseDouble(grades.get(i).getText()) >= 4.95) {
                resultsPage.itemsList.get(i).click();
                break;
            }
        }
    }

}
