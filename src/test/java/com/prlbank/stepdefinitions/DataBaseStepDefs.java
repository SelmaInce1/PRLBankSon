package com.prlbank.stepdefinitions;

import com.prlbank.utilities.DatabaseUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DataBaseStepDefs {

    public static void main(String[] args) {
        DatabaseUtility.createConnection();
        String query= "Select * from tp_customer ";

        /*
        List<String> sutunIsimleri=DatabaseUtility.getColumnNames(query);
        System.out.println(sutunIsimleri);
         */
        System.out.println(DatabaseUtility.getColumnNames(query));
        System.out.println("====================================");
        System.out.println(DatabaseUtility.getColumnData(query,"first_name"));
        System.out.println("====================================");
        System.out.println(DatabaseUtility.getCellValue(query,5,10));


    }

    List<Object> customerSsns;

    @Given("ders user creates a connection with db using {string} , {string} and {string}")
    public void ders_user_creates_a_connection_with_db_using_and(String url, String user, String password) {
        //Database baglanti
        DatabaseUtility.createConnection(url, user, password);

    }

    @Given("ders user reads the Customers data using {string} and {string}")
    public void ders_user_reads_the_Customers_data_using_and(String query, String ssn) {
        customerSsns=DatabaseUtility.getColumnData(query,ssn);
        //System.out.println(customerSsns);
        //System.out.println(customerSsns.size());
    }

    @Then("ders validate customers data")
    public void ders_validate_customers_data() {
        String filePath="src/test/resources/testdata/CustomerSsnInfo.txt";
        List<String> expectedSsns= new ArrayList<>();
        expectedSsns.add("476-90-9374");
        //expectedSsns.add("245-12-6789");
        //expectedSsns.add("245-12-6781");
        //expectedSsns.add("589-25-1478");

        Assert.assertTrue(customerSsns.containsAll(expectedSsns));
        System.out.println("Validation successfull!");


    }

}