package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.steps.libraries.HomeActions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class HomeStepsDefinitions {
    static VacationDetails vacationDetails;
    @Steps
    private HomeActions bob;

    @Given("^(?:.*) is on the home page$")
    public void isOnTheHomePage() {
        bob.opensHomePage();

    }

    @When("^he searches for booking options with preferences:$")
    public void heSubmitsASearchForTheDesiredDestinationWithHisDetails(List<VacationDetails> data) throws InterruptedException {

        vacationDetails = data.get(0);
        bob.searchesForVacationOptions(vacationDetails);
    }

    @Before("@eur_currency")
    public void initEURCurrency() {
        bob.opensHomePage();
        bob.selectsEURCurrency();
    }

}
