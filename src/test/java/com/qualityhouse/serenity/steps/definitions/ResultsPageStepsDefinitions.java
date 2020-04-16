package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.entities.VacationFilters;
import com.qualityhouse.serenity.page_objects.ResultsPage;
import com.qualityhouse.serenity.steps.libraries.ResultsPageActions;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static com.qualityhouse.serenity.page_objects.ResultsPage.FINAL_PRICE_LOCATOR;

public class ResultsPageStepsDefinitions {
    @Steps
    private ResultsPageActions bob;
    private ResultsPage resultsPage;

    @When("^he selects the first place with at least (\\d+\\.?\\d*) stars from the options filtered by:$")
    public void submitsLodgingPreferences(double rating, List<VacationFilters> data)  {

        VacationFilters vacationFilters = data.get(0);

        bob.filtersBy(vacationFilters);
        bob.clicksOnFirstResultWithRateEqualOrAbove(rating);
        HomeStepsDefinitions.vacationDetails.setFinalPrice(bob.readsPrice(FINAL_PRICE_LOCATOR));
        bob.switchesToOfferTab();
    }
}
