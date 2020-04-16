package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.entities.VacationFilters;
import com.qualityhouse.serenity.page_objects.ResultsPage;
import com.qualityhouse.serenity.steps.libraries.ResultsPageActions;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class ResultsPageStepsDefinitions {

    @Steps
    private ResultsPageActions bob;
    private ResultsPage resultsPage;

    @And("^he select first five and above star place filtered by:$")
    public void submitsLodgingPreferences(List<VacationFilters> data) throws InterruptedException {

        VacationFilters vacationFilters = data.get(0);

        bob.selectFilters(vacationFilters);
        Thread.sleep(1000);
        bob.clicksOnFirstResultWithGradeFiveOrAbove();
        Thread.sleep(1000);
        bob.switchToNewTab(1);
    }
}
