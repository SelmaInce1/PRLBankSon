package com.prlbank.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class US0025StepDefinitions{

    @Given("user goes API")
    public void userGoesAPI() {

    }

    @And("user goes to {string} and creates a country {string} and state {string}")
    public void userGoesToAndCreateACountryAndState(String url, String name, String country) {

    }


    @Then("user validates country and state")
    public void userValidatesCountryAndState() {


    }
}