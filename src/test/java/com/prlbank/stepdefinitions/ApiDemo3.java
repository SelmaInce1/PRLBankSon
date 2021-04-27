package com.prlbank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prlbank.pages.PRLAccountsPage;
import com.prlbank.pages.PRLCreateOrEditACustomerPage;
import com.prlbank.pages.PRLCustomersPage;
import com.prlbank.pages.PRLEmployeePage;
import com.prlbank.pojos.Customer;
import com.prlbank.utilities.*;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiDemo3 {
    Customer[] customers;
    ObjectMapper object;
    Response response;
    Response responseCountry;
    JsonPath jsonPath;
    String filePath = ConfigurationReader.getProperty("filePath_customers");
    PRLEmployeePage prlEmployeePage = new PRLEmployeePage();
    PRLAccountsPage prlAccountsPage = new PRLAccountsPage();
    PRLCreateOrEditACustomerPage prlCreateOrEditACustomerPage = new PRLCreateOrEditACustomerPage();
    String token = ConfigurationReader.getProperty("token");
    PRLCustomersPage prlCustomersPage = new PRLCustomersPage();
    int actualId;
    List<String> countriesList;

    @And("Authorized user on the api endpoint “customers_api” and read the customers")
    public void authorizedUserOnTheApiEndpointCustomers_apiAndReadTheCustomers() {
        response = RestAssured.
                given().
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                auth().
                oauth2(token).
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


        if (file != null) {
            file.delete();
        }
        WriteToTxt.saveDataInFileWithSSN(filePath, customers);

        List<String> actual = ReadTxt.returnCustomerSNNList(filePath);
        Assert.assertTrue("SSN doesn't match", actual.contains(ConfigurationReader.getProperty("demossn")));
        System.out.println("Customer's SSN is Successfully validated");

    }

    @And("user create a country with countries api end point {string}")
    public void userCreateACountryWithCountriesApiEndPoint(String country) {
        String createdCountry = "{\n" +
                "\"name\": \""+ ConfigurationReader.getProperty(country) +"\",\n" +
                "\"states\": null\n" +
                "} ";
        responseCountry = given().
                headers("Authorization",
                        "Bearer " + token,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                contentType(ContentType.JSON).
                body(createdCountry).
                post(ConfigurationReader.getProperty("countriesEndPoint")).
                then().
                contentType(ContentType.JSON).extract().response();

        responseCountry.prettyPrint();


        jsonPath = responseCountry.jsonPath();
        actualId = jsonPath.getInt("id");
        //System.out.println(jsonPath.getString("name"));
        System.out.println(actualId);


    }

    @And("employee navigate create or edit customer page")
    public void employeeNavigateCreateOrEditCustomerPage() {
        prlEmployeePage.MyOperations.click();
        Driver.wait(2);
        prlEmployeePage.ManageCustomers.click();
        Driver.wait(2);
        prlCustomersPage.createANewCustomerButton.click();
        Driver.wait(2);
    }

    @And("employee can validate new country created {string}")
    public void employeeCanSelectNewCountryCreated(String country) {
        countriesList = BrowserUtils.getAllOptionsAndSelect(prlCreateOrEditACustomerPage.multiSelectDDCountry, ConfigurationReader.getProperty(country));
        Assert.assertTrue(countriesList.contains(ConfigurationReader.getProperty(country)));
    }

    @And("user update created country using api end point {string}")
    public void userUpdateCreatedCountryUsingApiEndPoint(String country) {

        Map<String, Object> CountryInfoToBeUpdated= new HashMap<>();
        CountryInfoToBeUpdated.put("id",actualId);
        CountryInfoToBeUpdated.put("name",ConfigurationReader.getProperty("team43_countryUpdated"));
        CountryInfoToBeUpdated.put("states", null);

        responseCountry = given().
                headers("Authorization",
                        "Bearer " + token,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                contentType(ContentType.JSON).
                body(CountryInfoToBeUpdated).
                put(ConfigurationReader.getProperty("countriesEndPoint")).
                then().
                extract().
                response();

        responseCountry.prettyPrint();


    }
    @And("employee can validate new country updated {string}")
    public void employeeCanSelectNewCountryUpdated(String country) {
        /*BrowserUtils.selectDdValue(prlCreateOrEditACustomerPage.multiSelectDDCountry, ConfigurationReader.getProperty(country));
        Driver.wait(2);
        List<String> countriesList = new ArrayList<>();
        Select select = new Select(prlCreateOrEditACustomerPage.multiSelectDDCountry);
        List<WebElement> countries = select.getOptions();
        for (int i = 0; i < countries.size(); i++) {
            countriesList.add(countries.get(i).getText());
        }*/
        countriesList = BrowserUtils.getAllOptionsAndSelect(prlCreateOrEditACustomerPage.multiSelectDDCountry, ConfigurationReader.getProperty(country));
        Assert.assertTrue(countriesList.contains(ConfigurationReader.getProperty(country)));

    }

    @And("user delete created country using api end point {string}")
    public void userDeleteCreatedCountryUsingApiEndPoint(String endPoint) {
        String deletedCountryEndPoint = ConfigurationReader.getProperty("countriesEndPoint");

        responseCountry = given().
                headers("Authorization",
                        "Bearer " + token,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                delete(ConfigurationReader.getProperty(endPoint) + "/" + actualId).
                then().
                extract().response();

    }

    @And("employee can not select new country deleted {string}")
    public void employeeCanNotSelectNewCountryDeleted(String country) {
        countriesList = BrowserUtils.getAllOptions(prlCreateOrEditACustomerPage.multiSelectDDCountry);
        Assert.assertFalse(countriesList.contains(ConfigurationReader.getProperty(country)));
    }
}
