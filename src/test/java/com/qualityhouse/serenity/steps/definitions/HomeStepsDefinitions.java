package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.VacationDetails;
import com.qualityhouse.serenity.steps.libraries.HomeActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeStepsDefinitions {

    @Steps
    private HomeActions bob;

    @Given("^(?:.*) is on the home page and chooses Euro as his currency$")
    public void isOnTheHomePage() {
        bob.opensHomePage();
        bob.selectsCurrency();
    }

    @When("^he submits a search for the desired destination with his details:$")
    public void heSubmitsASearchForTheDesiredDestinationWithHisDetails(List<VacationDetails> data) throws InterruptedException {

        VacationDetails details = data.get(0);



        bob.submitVacationDetails(details);

    }
}
