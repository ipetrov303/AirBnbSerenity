package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.page_objects.ResultsPage;

import java.util.List;

import static com.qualityhouse.serenity.page_objects.ResultsPage.*;


public class ResultsPageActions extends BaseActions {

    ResultsPage resultsPage;

    public void selectFilters(VacationDetails details){

        clicksOn(PRICE_RANGE_BUTTON_LOCATOR);
        fillsFieldWithData(MINIMAL_PRICE_FIELD_LOCATOR, details.getPriceFrom());
        fillsFieldWithData(MAXIMAL_PRICE_FIELD_LOCATOR, details.getPriceTo());
        clicksOn(PRICE_FILTER_SAVE_BUTTON);
    }


}
