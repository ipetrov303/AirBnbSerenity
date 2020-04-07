package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.steps.libraries.ResultsPageActions;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class ResultsPageStepsDefinitions {

    @Steps
    private ResultsPageActions bob;

    @And("^he select first five and above star place filtered by:$")
    public void submitsLodgingPreferences(List<VacationDetails> data){

        VacationDetails details = data.get(0);

        bob.selectFilters(details);
    }
}
