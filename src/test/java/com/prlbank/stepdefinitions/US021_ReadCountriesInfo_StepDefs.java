package com.prlbank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prlbank.pojos.Country;
import com.prlbank.pojos.Customer;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.ReadTxt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.prlbank.utilities.WriteToTxt.saveDataInFileWithCountrId;
import static io.restassured.RestAssured.given;

public class US021_ReadCountriesInfo_StepDefs {

    Response response;
    Customer[] customer;
    Country[] country;

    @Given("user goes to API end point {string} and read countries")
    public void userGoesToAPIEndPointAndReadCountries(String arg0) {
       response = given()
                .header("Authoriation",
                        "Bearer " + ConfigurationReader.getProperty("bearer_token"),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
               .when()
               .get(ConfigurationReader.getProperty("country_api"))
               .then()
               .contentType(ContentType.JSON)
               .statusCode(200)
               .extract()
               .response();

       response.prettyPrint();
    }

    List<String> idList= new ArrayList<>();

    @And("user validate countries from data set")
    public void userValidateCountriesFromDataSet() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        country = objectMapper.readValue(response.asString(), Country[].class);
        for (int i = 0; i < country.length; i++) {
            idList.add(country[i].getId());
            System.out.println("id  :" + country[i].getId());
        }
        JsonPath jsonPath = response.jsonPath();
        String countryId = jsonPath.getString("id");
        Assert.assertTrue("Country does not exist.", countryId.contains("74418"));


    }

    @Then("user create a countries {string} using API end point {string}")
    public void userCreateACountriesUsingAPIEndPoint(String arg0, String arg1) {
        String newCountry = "{\n" +
                "\"name\": \" "+ country + "\",\n" +
                "\"states\": null\n" +
                "}";


        response = given()
                .headers("Authorization",
                        "Bearer " + ConfigurationReader.getProperty("bearer_token"),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .contentType(ContentType.JSON)
                .body(newCountry)
                .post(ConfigurationReader.getProperty("country_api"))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

        response = given()
                .headers("Authorization",
                        "Bearer " + ConfigurationReader.getProperty("bearer_token"),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .contentType(ContentType.JSON)
                .get(ConfigurationReader.getProperty("country_api"))
                .then()
                .extract()
                .response();
    }




    @And("user validate countries created")
    public void userValidateCountriesCreated() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        country = obj.readValue(response.asString(), Country[].class);


        int lastCountryLength = country.length - 1;
        String expectedId = country[lastCountryLength].getId();

        saveDataInFileWithCountrId(ConfigurationReader.getProperty("filePathCountryId"), country);

        List<String> actualIDs = ReadTxt.returnCountryIdList(ConfigurationReader.getProperty("filePathCountryId"));

        org.testng.Assert.assertTrue(actualIDs.contains(expectedId));



    }
}
