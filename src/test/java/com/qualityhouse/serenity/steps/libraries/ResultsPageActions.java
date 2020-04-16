package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationFilters;
import com.qualityhouse.serenity.page_objects.ResultsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;

import static com.qualityhouse.serenity.page_objects.ResultsPage.*;


public class ResultsPageActions extends BaseActions {

    ResultsPage resultsPage;

    @Step
    public void filtersBy(VacationFilters details) {

        clicksOn(PRICE_RANGE_BUTTON_LOCATOR);
        fillsFieldWithData(MINIMAL_PRICE_FIELD_LOCATOR, details.getPriceFrom());
        fillsFieldWithData(MAXIMAL_PRICE_FIELD_LOCATOR, details.getPriceTo());
        clicksOn(PRICE_FILTER_SAVE_BUTTON);
        clicksOn(MORE_FILTERS_BUTTON_LOCATOR);
        clicksOnIncreaseButton(details.getBathrooms(), resultsPage.addBathroomButton);
        clicksMultipleOptions(Arrays.asList(details.getExtras().split(", ")));
        clicksOn(resultsPage.submitFiltersButton);
        resultsPage.waitForRenderedElementsToDisappear(EMPTY_OTHER_FILTERS_LOCATOR);
    }

    @Step
    public void clicksOnFirstResultWithRateEqualOrAbove(double rating) {
        boolean isFound = false;
        while (!isFound)
        {
            for (WebElementFacade webElementFacade : resultsPage.itemsList) {
                if (webElementFacade.containsElements(GRADE_LOCATOR) &&
                        Double.parseDouble(webElementFacade.find(GRADE_LOCATOR).getText()) >= rating ) {
                    isFound = true;
                    clicksOn(webElementFacade);
                    break;
                }
            }

            if (!isFound) {
                clicksOn(resultsPage.nextPageArrowButton);
            }
        }
    }
}
