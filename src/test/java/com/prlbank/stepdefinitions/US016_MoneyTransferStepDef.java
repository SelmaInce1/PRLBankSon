package com.prlbank.stepdefinitions;

import com.prlbank.pages.*;
import com.prlbank.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;

public class US016_MoneyTransferStepDef {
    PRLRegistrationPage prlRegistrationPage = new PRLRegistrationPage();
    PRLHomePage prlHomePage = new PRLHomePage();
    PRLSignInPage prlSignInPage = new PRLSignInPage();
    PRLAdminHomePage prlAdminHomePage = new PRLAdminHomePage();
    PRLEmployeePage prlEmployeePage = new PRLEmployeePage();
    PRLCustomersPage prlCustomersPage = new PRLCustomersPage();
    PRLCreateOrEditACustomerPage prlCreateOrEditACustomerPage = new PRLCreateOrEditACustomerPage();
    PRLCreateOrEditAnAccountPage prlCreateOrEditAnAccountPage = new PRLCreateOrEditAnAccountPage();
    PRLAccountsPage prlAccountsPage = new PRLAccountsPage();
    PRLUserPage prlUserPage = new PRLUserPage();

    @Then("user enter a valid username as customer")
    public void userEnterAValidUsernameAsCustomer() {
        prlHomePage.icon.click();
        prlHomePage.signInButton.click();
        prlSignInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("username"));
    }

    @Then("user enter a valid password as customer")
    public void userEnterAValidPasswordAsCustomer() {
        prlSignInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @Then("user logs in")
    public void userLogsIn() {
        prlSignInPage.signInButton.click();
    }

    @Then("user clicks on Transfer Money")
    public void userClicksOnTransferMoney() {
        prlUserPage.TransferMoney.click();
    }

    @Then("user select an account on the from box")
    public void userSelectAnAccountOnTheFromBox() {
        prlUserPage.fromAccount.sendKeys(ConfigurationReader.getProperty("firstAccount"));
    }

    @Then("user select an account on the to box")
    public void userSelectAnAccountOnTheToBox() {
        prlUserPage.toAccount.sendKeys(ConfigurationReader.getProperty("secondAccount"));
    }

    @Then("user enter balance")
    public void userEnterBalance() {
        prlUserPage.balanceTextBox.sendKeys(ConfigurationReader.getProperty("balance"));
    }

    @Then("user enter description")
    public void userEnterDescription() {
        prlUserPage.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("description"));
    }

    @Then("user click Make Transfer button")
    public void userClickMakeTransferButton() {
        prlUserPage.MakeTransferButton.click();
    }

    @Then("user should see transfer is done successfully validating the message")
    public void userShouldSeeTransferIsDoneSuccessfullyValidatingTheMessage() {
    }

}
