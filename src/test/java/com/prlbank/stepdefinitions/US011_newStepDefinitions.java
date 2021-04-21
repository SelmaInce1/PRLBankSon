package com.prlbank.stepdefinitions;

import com.prlbank.pages.*;
import com.prlbank.utilities.BrowserUtils;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;

public class US011_newStepDefinitions {

    PRLHomePage prlHomePage = new PRLHomePage();
    PRLSignInPage prlSignInPage = new PRLSignInPage();
    PRLManagerHomePage prlManagerHomePage = new PRLManagerHomePage();
    PRLCustomersPage prlCustomersPage = new PRLCustomersPage();
    PRLCreateOrEditACustomerPage prlCreateOrEditACustomerPage = new PRLCreateOrEditACustomerPage();


    @Then("user enter first name")
    public void user_enter_first_name() {
        prlCreateOrEditACustomerPage.firstNameTextBox.sendKeys("Ali");
    }

    @Then("user enter last name")
    public void user_enter_last_name() {
        prlCreateOrEditACustomerPage.lastNameTextBox.sendKeys("Haydar");
    }

    @Then("user enter Middle Initial")
    public void user_enter_middle_initial() {
        prlCreateOrEditACustomerPage.middleInitialTextBox.sendKeys("AH");
    }

    @Then("user enter Email")
    public void user_enter_email() {
        prlCreateOrEditACustomerPage.emailTextBox.sendKeys("AliHaydar@is.mail");
    }

    @Then("user enter Mobile Phone Number")
    public void user_enter_mobile_phone_number() {
        prlCreateOrEditACustomerPage.mobilePhoneNumberTextBox.sendKeys("789-456-1230");
    }

    @Then("user enter Phone Number")
    public void user_enter_phone_number() {
        prlCreateOrEditACustomerPage.phoneNumberTextBox.sendKeys("789-456-1230");
    }

    @Then("user enter Zip Code")
    public void user_enter_zip_code() {
        prlCreateOrEditACustomerPage.zipCodeTextBox.sendKeys("34001");
    }

    @Then("user enter Address")
    public void user_enter_address() {
        prlCreateOrEditACustomerPage.addressTextBox.sendKeys("1903 Besiktas");
    }

    @Then("user enter City")
    public void user_enter_city() {
        prlCreateOrEditACustomerPage.cityTextBox.sendKeys("Istanbul");
    }

    @Then("user enter Ssn number")
    public void user_enter_ssn_number() {
        prlCreateOrEditACustomerPage.ssnTextBox.sendKeys("789-45-6123");
    }

    @Then("user select valid date in Date table and verify Date")
    public void userSelectValidDateInDateTableAndVerifyDate() {
        //SimpleDateFormat currentDate =new SimpleDateFormat();
        String currentDate;
        currentDate = prlCreateOrEditACustomerPage.createDateSelect.getText();
        String createdDate = "13-Apr-2021 12:00 AM";
        prlCreateOrEditACustomerPage.createDateSelect.sendKeys("createdDate");
        boolean date;
        if (currentDate.equals(createdDate)) {
            date = true;
        } else {
            date = false;
        }
        System.out.println(createdDate + "=" + currentDate);
        Assert.assertTrue(date);
        Driver.wait(1);
    }

    //    @Then("user select valid date in Date table")
//    public void user_select_valid_date_in_date_table() {
//    }
//    @Then("user verify date of in the Create date box")
//    public void user_verify_date_of_in_the_create_date_box() {
//
//    }
    @Then("user select the country on the Country Box")
    public void user_select_the_country_on_the_country_box() {
        BrowserUtils.selectDdValue(prlCreateOrEditACustomerPage.multiSelectDDCountry, "TURKEY");

    }

    @Then("user enter State")
    public void user_enter_state() {
        prlCreateOrEditACustomerPage.stateTextBox.sendKeys("Marmara");
    }

    @Then("user select the user on the User Box")
    public void user_select_the_user_on_the_user_box() {
        BrowserUtils.selectDdValue(prlCreateOrEditACustomerPage.multiSelectDDUser, "");
    }

    @Then("user select an account on the Account Box")
    public void user_select_an_account_on_the_account_box() {
        BrowserUtils.selectDdValue(prlCreateOrEditACustomerPage.multiSelectAccount, "Saving Account");
    }

    @Then("user check the Zelle Enrolled box")
    public void user_check_the_zelle_enrolled_box() {
        prlCreateOrEditACustomerPage.zelleEnrolledCheckBox.click();
    }


    @Then("user clicks on save button")
    public void userClicksOnSaveButton() {
        prlCreateOrEditACustomerPage.saveButton.click();
    }

    @Then("user verify account created")
    public void user_verify_account_created() {

    }


}
