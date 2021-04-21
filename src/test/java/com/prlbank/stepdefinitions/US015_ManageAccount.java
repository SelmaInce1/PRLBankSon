package com.prlbank.stepdefinitions;

import com.prlbank.pages.PRLHomePage;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US015_ManageAccount {
    PRLHomePage prlHomePage = new PRLHomePage();


    @Given("User goes to login page")
    public void userGoesToLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("prlbank_url"));
        Driver.waitAndClick(prlHomePage.icon,3);
        prlHomePage.signInButton.click();
        Driver.wait(5);
    }

    @When("user enters a valid username and password")
    public void userEntersAValidUsernameAndPassword() {
    }

    @Then("User logs in")
    public void userLogsIn() {
    }

    @When("user clicks on My Operations")
    public void userClicksOnMyOperations() {
    }

    @Then("user clicks on Manage Accounts")
    public void userClicksOnManageAccounts() {
    }

    @Then("user clicks on a desired account id")
    public void userClicksOnADesiredAccountId() {
    }

    @And("user clicks View button")
    public void userClicksViewButton() {
    }

    @And("user can click Edit button")
    public void userCanClickEditButton() {
    }

    @Then("user can update Account Type")
    public void userCanUpdateAccountType() {
    }
}
