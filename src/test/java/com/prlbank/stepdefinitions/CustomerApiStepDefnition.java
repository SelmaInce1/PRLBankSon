package com.prlbank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prlbank.pojos.Country;
import com.prlbank.pojos.Customer;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.ReadTxt;
import com.prlbank.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class CustomerApiStepDefnition {

    Response response;
    String apiToken= ConfigurationReader.getProperty("Bearer");
    Customer[] customer;
    String filePath = ConfigurationReader.getProperty("filePath_Customer_Ssn");
    Response responseAll;

    @Given("All customer API data is set to response using api end point {string}")
    public void allCustomerAPIDataIsSetToResponseUsingApiEndPoint(String api_endpoint) {
        response = given().
                headers("Authorization",
                        "Bearer "+ apiToken,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                contentType(ContentType.JSON).
                get(ConfigurationReader.getProperty(api_endpoint)).
                then().
                extract().
                response();

        //response = given().auth().oauth2(apiToken) Ikinci bir authorization bicimi(Bearer type icin)
        //response.prettyPrint();
    }

    @Given("all customer info will be set to customers with deserialization")
    public void allCustomerInfoWillBeSetToCustomersWithDesirialization() throws IOException {
        ObjectMapper obje=new ObjectMapper();
        customer=obje.readValue(response.asString(), Customer[].class);

        for (int i = 0; i < customer.length; i++) {
            if (customer[i].getUser() != null) {
                System.out.println(customer[i].getUser().getLogin());
            }
        }
        //System.out.println(customer3[4].getCountry3().getStates3());

        /*
        for (int i = 0; i < customer.length; i++) {
            if (customer[i].getCountry() !=null){
                System.out.println(customer[i].getCountry().getName());
            }
        }
        country isimlerini alir
         */

    }

    @And("all customer info will be saved to txt files")
    public void allCustomerInfoWillBeSavedToTxtFiles() {

        WriteToTxt.saveDataInFileWithSSN(filePath, customer);

    }



    @Then("all customer info has been validated")
    public void allCustomerInfoHasBeenValidated() {
        /*
821-84-3971
108-53-6655
224-71-4004
398-56-4356
         */

        List<String> expectedSsns = new ArrayList<>();
        expectedSsns.add("821-84-3971");
        expectedSsns.add("108-53-6655");
        expectedSsns.add("224-71-4004");
        expectedSsns.add("398-56-4356");

        List<String> actualList = ReadTxt.returnCustomerSNNList(filePath);
        assertTrue("Ssn'ler eslesmiyor", actualList.containsAll(expectedSsns));

    }


}


