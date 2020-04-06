package com.qualityhouse.serenity;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author yakimfb
 * @since 12.03.20
 **/

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "features",
        glue = "com/qualityhouse/serenity/steps/definitions",
        tags = {""})
public class TestRunner {
}
