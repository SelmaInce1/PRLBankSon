package com.prlbank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prlbank.pojos.Applicants;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.ReadTxt;
import com.prlbank.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class US_023_ReadAllApplicantsStepDefinition {
    Applicants[] applicants;
    ObjectMapper object;
    Response response;
    JsonPath jsonPath;
    String filePath = ConfigurationReader.getProperty("filePath_Read_Applicants");

    @Given("Authorized user goes to api end point {string}")
    public void AuthorizedUserGoesToApiEndPoint(String endpoint) {
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

        //response.prettyPrint();

        jsonPath = response.jsonPath();
    }

    @And("Authorized user validate data")
    public void AuthorizedUserValidateData() throws IOException {
        object = new ObjectMapper();
        applicants = object.readValue(response.asString(), Applicants[].class);
        File file = new File(filePath);
        if(file != null){
            file.delete();
        }
        WriteToTxt.saveDataInFileWithApplicantsId(filePath, applicants);


        List<Applicants> actual = ReadTxt.returnApplicantsId(filePath);
        for(int i=0; i<applicants.length; i++) {
            System.out.println(actual.get(i).getId());
        }
        System.out.println(actual.size());
        int totalNumberOfId=actual.size();
        Assert.assertEquals("Total number of Id didn't mach",3011, actual.size());
        if(!actual.isEmpty()){
            System.out.println("Read and Pass");
        }else{
            System.out.println("Read and Fall");
        }//Assert ile yapilabilir
    }

}

