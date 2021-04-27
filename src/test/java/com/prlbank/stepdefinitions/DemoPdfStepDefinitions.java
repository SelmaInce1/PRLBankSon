package com.prlbank.stepdefinitions;

import com.prlbank.pojos.Country;
import com.prlbank.pojos.Customer;
import com.prlbank.utilities.DatabaseUtility;
import com.prlbank.utilities.PDFGenerator;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

public class DemoPdfStepDefinitions {

    public static void main(String[] args) {
        PDFGenerator.pdfGeneratorRowsAndCells("PDF Example", "src/test/resources/testdata/DemoPDF.pdf");
    }

    @Given("User creates a connection with db using {string} , {string} and {string}")
    public void UserCreatesAConnectionWithDbUsingAnd(String url, String user, String password) {
        DatabaseUtility.createConnection(url, user, password);
    }

    @And("User provides the query {string} {string}")
    public void UserProvidesTheQuery(String query, String countStr) {

        List<List<Object>> actualCustomers = DatabaseUtility.getQueryResultList(query);
        System.out.println(actualCustomers.size());
        System.out.println(actualCustomers.toString());

        List<Customer> customerList = new ArrayList<Customer>();
        int count = Integer.parseInt(countStr);
        for (int i = 1; i < count+1; i++) {
            /*
            headers.add("Firstname");
            headers.add("LastName");
            headers.add("Email");
            headers.add("City");
            headers.add("SSN Number");
             */
            Customer customers = new Customer();
            customers.setFirstName(actualCustomers.get(i).get(1).toString());
            customers.setLastName(actualCustomers.get(i).get(5).toString());
            customers.setEmail(actualCustomers.get(i).get(4).toString());
            customers.setCity(actualCustomers.get(i).get(9).toString());
            customers.setSsn(actualCustomers.get(i).get(10).toString());
            customerList.add(customers);
        }

        PDFGenerator.pdfGeneratorRowsAndCellsWithList("Customer", customerList, "src/test/resources/testdata/First20Customers.pdf");


    }

}
