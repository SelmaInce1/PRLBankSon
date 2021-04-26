package com.prlbank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prlbank.pojos.Applicants;
import com.prlbank.pojos.Customer;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.ReadTxt;
import com.prlbank.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ApiDemo3 {
    Customer[] customers;
    ObjectMapper object;
    Response response;
    JsonPath jsonPath;
    String filePath = ConfigurationReader.getProperty("filePath_customers");

    @And("Authorized user on the api endpoint “customers_api” and read the customers")
    public void authorizedUserOnTheApiEndpointCustomers_apiAndReadTheCustomers() {
        response = RestAssured.
                given().
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                auth().
                oauth2(ConfigurationReader.getProperty("token")).
                when().
                get(ConfigurationReader.getProperty("customersEndPoint")).
                then().
                extract().
                response();

        //response.prettyPrint();

        jsonPath = response.jsonPath();
    }

    @And("Validate the customer")
    public void validateTheCustomer() throws IOException {
        object = new ObjectMapper();
        customers = object.readValue(response.asString(), Customer[].class);
        File file = new File(filePath);
        if(file != null){
            file.delete();
        }
        WriteToTxt.saveDataInFileWithSSN(filePath, customers);

               List<String> actual = ReadTxt.returnCustomerSNNList(filePath);
        Assert.assertTrue("SSN doesn't match", actual.contains(ConfigurationReader.getProperty("demossn")));
        System.out.println("Customer's SSN is Successfully validated");

    }
}
