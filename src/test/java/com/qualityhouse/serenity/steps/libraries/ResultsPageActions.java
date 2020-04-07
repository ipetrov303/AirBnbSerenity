package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.ResultsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collections;
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
        for (WebElementFacade grade : grades) {
            System.out.println(grade.getText());
            if (grade.getText().equals("5.0")){
                grade.waitUntilClickable().click();
                break;
            }
        }
    }

}
