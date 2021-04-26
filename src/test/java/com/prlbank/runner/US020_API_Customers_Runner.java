package com.prlbank.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/default-cucumber_reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml" },
        features="src/test/resources/features",
        glue= "com/prlbank/stepdefinitions",
        dryRun = false,
        tags = "@US020CustomerApi"
)
public class US020_API_Customers_Runner {

}
