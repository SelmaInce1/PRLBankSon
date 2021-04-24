package com.prlbank.stepdefinitions;

import com.prlbank.pojos.States;
import com.prlbank.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class US024StepDefinitions {
    Response response;
    JsonPath jsonPath;


    @Given("user goes API")
    public void userGoesAPI(String endpoint) {
            response = RestAssured.
                    given().
                    accept(ContentType.JSON).
                    contentType(ContentType.JSON).
                    auth().
                    oauth2(ConfigurationReader.getProperty("token")).
                    when().
                    get(endpoint).
                    then().
                    extract().
                    response();


        }

    @And("user goes to {string} and creates a country {string} and state {string}")
    public void userGoesToAndCreateACountryAndState(String url, String state, String country) {





    }


    @Then("user validates country and state")
    public void userValidatesCountryAndState() {


    }
}
