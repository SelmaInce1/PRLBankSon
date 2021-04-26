package com.prlbank.stepdefinitions;

import com.prlbank.pojos.Country;
import com.prlbank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class US026_UpdateCountriesStepdefs {
Country[]countries;
    Response response;
    JsonPath jsonPath;
    @Given("User goes to api end point {string}")
    public void user_goes_to_api_end_point(String endpoint) {

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
        response.prettyPrint();
        jsonPath = response.jsonPath();
    }

    @Given("User should update each country")
    public void user_should_update_each_country() {

    }

}
