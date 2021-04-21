package com.prlbank.stepdefinitions;

import com.prlbank.pages.PRLHomePage;
import com.prlbank.pages.PRLRegistrationPage;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class US001_StepDefinitons {
        PRLHomePage prlHomePage= new PRLHomePage();
        PRLRegistrationPage prlRegistrationPage= new PRLRegistrationPage();


        @Given("user on the {string}")
        public void userOnThe(String url) {//url olarak desgistirdim arg0=url
            Driver.getDriver().get(ConfigurationReader.getProperty("prlbank_url"));
        }

        @And("User navigates to registration page")
        public void userNavigatesToRegistrationPage() {
           prlHomePage.icon.click();
           prlHomePage.register.click();
        }

        @Then("User provides a valid ssn")
        public void userProvidesAValidSsn() {
           prlRegistrationPage.SSNTextBox.sendKeys(ConfigurationReader.getProperty("ssn"));
        }

        @And("User provides a valid firstname")
        public void userProvidesAValidFirstname() {

                prlRegistrationPage.firstNameTextBox.sendKeys(ConfigurationReader.getProperty("name"));
        }

        @And("User provides a valid lastname")
        public void userProvidesAValidLastname() {
            prlRegistrationPage.lastNameTextBox.sendKeys(ConfigurationReader.getProperty("lastname"));

        }

        @And("User provides a valid address")
        public void userProvidesAValidAddress() {
                prlRegistrationPage.addressTextBox.sendKeys(ConfigurationReader.getProperty("address"));
        }

        @And("User provides a valid phonenumber")
        public void userProvidesAValidPhonenumber() {
                prlRegistrationPage.mobilePhoneNumberTextBox.sendKeys(ConfigurationReader.getProperty("phone"));
        }

        @And("User provides a valid username")
        public void userProvidesAValidUsername() {
                prlRegistrationPage.userNameTextBox.sendKeys(ConfigurationReader.getProperty("username"));
        }

        @And("User provides a valid email")
        public void userProvidesAValidEmail() {
                prlRegistrationPage.emailTextBox.sendKeys(ConfigurationReader.getProperty("email"));
        }

        @And("User provides password")
        public void userProvidesPassword() {
                prlRegistrationPage.newPasswordTextBox.sendKeys(ConfigurationReader.getProperty("password"));
        }

        @And("User provides a valid password confirmation")
        public void userProvidesAValidPasswordConfirmation() {
                prlRegistrationPage.passwordConfirmationTextBox.sendKeys(ConfigurationReader.getProperty("password"));
        }

        @And("User clicks Register button")
        public void userClicksRegisterButton() {
                prlRegistrationPage.registerButton.click();
        }

        @And("User waits for {int} miliseconds")
        public void userWaitsForMiliseconds(int arg0) throws InterruptedException {
                Thread.sleep(1000);
        }
//
//        @And("User asserts thst he could register successfully")
//        public void userAssertsThstHeCouldRegisterSuccessfully() {
//
//        }
    }

