package com.prlbank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prlbank.pojos.Applicants;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.ReadTxt;
import com.prlbank.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ApiDemo2 {
    Applicants[] applicants;
    Applicants [] applicantsId;
    ObjectMapper object;
    Response response;
    JsonPath jsonPath;
    String filePath = ConfigurationReader.getProperty("filePath_applicantsId");
    //int expectedNumberOfId=2933;
    @Given("Authorized user on the api endpoint “applicants_api” and read the applicants")
    public void authorizedUserOnTheApiEndpointApplicants_apiAndReadTheApplicants() {
        response = RestAssured.
                given().
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                auth().
                oauth2(ConfigurationReader.getProperty("token")).
                when().
                get(ConfigurationReader.getProperty("applicantsEndPoint")).
                then().
                extract().
                response();

        //response.prettyPrint();

        jsonPath = response.jsonPath();
    }

    @And("Validate applicants read")
    public void validateApplicantsRead() throws IOException {

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

       // Assert.assertEquals("Total number of Id didn't mach",expectedNumberOfId, actual.size());

    }

    @And("create a applicant using to api end point “applicants_api”")
    public void createAApplicantUsingToApiEndPointApplicants_api() {
        String createdApllicant="{\n" +
                "        \"ssn\": \"124-45-4343\",\n" +
                "        \"firstName\": \"firstuser43\",\n" +
                "        \"lastName\": \"lastuser43\",\n" +
                "        \"address\": \"US\",\n" +
                "        \"mobilePhoneNumber\": \"345-342-3423\",\n" +
                "        \"userId\": 1202,\n" +
                "        \"userName\": \"User43\",\n" +
                "        \"email\": \"User43@gmail.com\",\n" +
                "        \"createDate\": \"2020-10-07T22:47:54.927Z\"\n" +
                "    }";
        Response response = RestAssured.given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body(createdApllicant)
                .post(ConfigurationReader.getProperty("applicantsEndPoint"))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

    }

    @And("Validate applicant create")
    public void validateApplicantCreate() throws IOException {
        object = new ObjectMapper();
        applicants = object.readValue(response.asString(), Applicants[].class);
        File file = new File(filePath);
        if(file != null){
            file.delete();
        }
        WriteToTxt.saveDataInFileWithApplicantsId(filePath, applicants);


        List<Applicants> actual = ReadTxt.returnApplicantsId(filePath);
        System.out.println(actual.size());
        Response responseLast=RestAssured.given().headers("Authorization","Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty("applicantsEndPoint"))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        //responseLast.prettyPrint();
        JsonPath json = responseLast.jsonPath();
        String id=json.getString("id");
        Assert.assertTrue("not verify",id.contains("91927"));


    }

    @And("user updates a applicant using api end point “applicants_api”  “firstName” and its extension “id”")
    public void userUpdatesAApplicantUsingApiEndPointApplicants_apifirstNameAndItsExtensionId() {
        Map<String,Object> updateEdilecekIdVeBilgileri=new HashMap<>();
        updateEdilecekIdVeBilgileri.put("id",91926);
        updateEdilecekIdVeBilgileri.put("ssn","124-34-6345");
        updateEdilecekIdVeBilgileri.put("firstName","Demo43FirstUpdate");
        updateEdilecekIdVeBilgileri.put("lastName","Demo43LastUpdate");
        updateEdilecekIdVeBilgileri.put("address","America");
        updateEdilecekIdVeBilgileri.put("mobilePhoneNumber","345-342-3423");
        updateEdilecekIdVeBilgileri.put("userId","1202");
        updateEdilecekIdVeBilgileri.put("userName","User43");
        updateEdilecekIdVeBilgileri.put("email","User43@gmail.com");
        updateEdilecekIdVeBilgileri.put("createDate",null);

        Response response = RestAssured.given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body(updateEdilecekIdVeBilgileri)
                .put(ConfigurationReader.getProperty("applicantsEndPoint"))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();

//        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
//                body("\"firstName\": \"Demo43FirstUpdate\",\n");

        JsonPath jsonPath = response.jsonPath();
        String actualApplicants = jsonPath.getString("firstName");
        //System.out.println(actualUlkeIsimleri);
     //   List<Integer> a = new ArrayList<>();
    //    a.add(123);
     //   a.add(234);
        Assert.assertTrue(actualApplicants.contains((String)updateEdilecekIdVeBilgileri.get("firstName")));
   //     Assert.assertTrue(a.contains(updateEdilecekIdVeBilgileri.get("firstName")));


    }
    @And("Validate applicant update")
    public void validateApplicantUpdate() {


    }

    @And("user deletes a applicant using endpoint “applicants_api” and its extension “id”")
    public void userDeletesAApplicantUsingEndpointApplicants_apiAndItsExtensionId() {
    }

    @And("Validate applicant delete")
    public void validateApplicantDelete() {
    }
}
