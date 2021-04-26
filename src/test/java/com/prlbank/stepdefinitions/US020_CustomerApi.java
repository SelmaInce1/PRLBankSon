package com.prlbank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prlbank.pojos.Customer;
import com.prlbank.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class US020_CustomerApi {

    Response response;
    String apiToken = ConfigurationReader.getProperty("bearer");
    Customer[] customer;


    @Given("all api data is set to  using api end point {string}")
    public void all_api_data_is_set_to_using_api_end_point(String api_endpoint) {

        response = given().
                   headers("Authorization" , "Bearer " + apiToken,
                           "Content-Type", ContentType.JSON,
                           "Accept", ContentType.JSON).
                when().
                contentType(ContentType.JSON).
                get(ConfigurationReader.getProperty(api_endpoint)).
                then().
                extract().
                response();

        response.prettyPrint();

    }

    @Given("all customer info will be set to customers with desirialization")
    public void all_customer_info_will_be_set_to_customers_with_desirialization() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        customer= obj.readValue(response.asString(), Customer[].class);




    }

    @Given("all customer info will be saved to correspondent files")
    public void all_customer_info_will_be_saved_to_correspondent_files() {

    }

    @Then("all customer info has been validated")
    public void all_customer_info_has_been_validated() {

    }
}