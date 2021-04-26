package com.prlbank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prlbank.pojos.Country;
import com.prlbank.pojos.Customer;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.ReadTxt;
import com.prlbank.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.prlbank.utilities.WriteToTxt.saveDataInFileWithCountrId;
import static io.restassured.RestAssured.given;

public class CustomerApi2StepDefinition {

    Response response;
    String apiToken= ConfigurationReader.getProperty("Bearer");
    Country[] country;
    String filePathCountryId = ConfigurationReader.getProperty("filePath_country_id");

    @And("ders create a country {string}")
    public void dersCreateACountry(String countryEndPoint) throws IOException {
        String createEdilecekUlke="{\n" +
                "\"name\": \"PRlBank deneme ulkesi 3\",\n" +
                "\"states\": null\n" +
                "} ";
        response = given().
                headers("Authorization",
                        "Bearer "+ apiToken,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                contentType(ContentType.JSON).
                body(createEdilecekUlke).
                post(countryEndPoint).
                then().
                contentType(ContentType.JSON).extract().response();


        //response.prettyPrint();

        response = given().
                headers("Authorization",
                        "Bearer "+ apiToken,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                contentType(ContentType.JSON).
                get(countryEndPoint).
                then().
                extract().
                response();

        //Burada get yapip gercekten olusturduk mu bu datayi diye bakiyoruz

        ObjectMapper obj=new ObjectMapper();
        country=obj.readValue(response.asString(), Country[].class);
        //System.out.println(country[country.length-2].getName());
        //System.out.println(country.length);

        int lastCountryLength= country.length-1;
        String expectedId=country[lastCountryLength].getId();

        saveDataInFileWithCountrId(filePathCountryId,country);

        List<String> actualDatas= ReadTxt.returnCountryIdList(filePathCountryId);
        System.out.println(actualDatas);

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualDatas.contains(expectedId));
        System.out.println("Soft Assert Olusturulan country database'de mevcut");

//        Assert.assertTrue(actualDatas.contains(expectedId));
//        System.out.println("Hard Assert Olusturulan country database'de mevcut");

        int count=0;
        for (int i=0;i<country.length;i++){
            if(country[i].getId().equals(expectedId)){
                count++;
            }
        }

        softAssert.assertTrue(count>0);

//soft Assert fail olursa Assertall a kadar komutlari yapmaya devam eder,
//fakat hard Assert fail olursa hic bir alt satiri bile devam etmez

    }

    @And("ders update created country using api end point {string}")
    public void dersUpdateCreatedCountryUsingApiEndPoint(String countryEndPoint) {
        Map<String,Object> updateEdilecekIdVeBilgileri=new HashMap<>();
        updateEdilecekIdVeBilgileri.put("id",92266);
        updateEdilecekIdVeBilgileri.put("name","PrlBank Deneme Updated 2 Ulkesi");
        updateEdilecekIdVeBilgileri.put("states",null);


        response = given().
                headers("Authorization",
                        "Bearer "+ apiToken,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                contentType(ContentType.JSON).
                body(updateEdilecekIdVeBilgileri).
                put(countryEndPoint).
                then().
                extract().
                response();

        response.prettyPrint();

        response = given().
                headers("Authorization",
                        "Bearer "+ apiToken,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                contentType(ContentType.JSON).
                get(countryEndPoint).
                then().
                extract().
                response();




    }

    @And("ders delete created country using api end point {string} {string}")
    public void dersDeleteCreatedCountryUsingApiEndPoint(String arg0, String arg1) {
    }

}
