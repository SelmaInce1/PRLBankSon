package com.prlbank.stepdefinitions;

import com.prlbank.pages.PRLHomePage;
import com.prlbank.pages.PRLSignInPage;
import com.prlbank.pages.PRLUserSettingsPage;
import com.prlbank.utilities.BrowserUtils;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US006_UserSettings {

    PRLHomePage prlHomePage = new PRLHomePage();
    PRLSignInPage prlSignInPage = new PRLSignInPage();
    PRLUserSettingsPage prlUserSettingsPage = new PRLUserSettingsPage();

    @Given("user goes to login page")
    public void userGoesToLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("prlbank_url"));
        Driver.waitAndClick(prlHomePage.icon,3);
        prlHomePage.signInButton.click();
        Driver.wait(5);
    }

    @Then("user signs in as a customer")
    public void userSignsInAsACustomer() {
        prlSignInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("customer_username"));
        prlSignInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("customer_password"));
        prlSignInPage.signInButton.click();
        Driver.wait(5);
    }

    @And("user navigates to user info")
    public void userNavigatesToUserInfo() {
        prlSignInPage.employeeDD.click();
        prlSignInPage.UserInfo.click();
        Driver.wait(5);
    }

    @Given("user updates {string}, lastname {string}, and email {string}")
    public void userUpdatesLastnameAndEmail(String fname, String lname, String email) {
        prlUserSettingsPage.FirstNameTextBox.clear();
        prlUserSettingsPage.FirstNameTextBox.sendKeys(fname);
        Driver.wait(3);
        prlUserSettingsPage.LastNameTextBox.clear();
        prlUserSettingsPage.LastNameTextBox.sendKeys(lname);
        Driver.wait(3);
        prlUserSettingsPage.EmailTextBox.clear();
        prlUserSettingsPage.EmailTextBox.sendKeys(email);
        Driver.wait(3);
    }

    @When("user selects turkish option from dropdown {string}")
    public void userSelectsTurkishOptionFromDropdown(String lang) {
        Driver.selectByIndex(prlUserSettingsPage.LanguageDD,1);
        Driver.wait(3);
    }

    @Then("user clicks save button")
    public void userClicksSaveButton() {
        prlUserSettingsPage.SaveButton.click();
    }

    @Then("user can see the aprroved message")
    public void userCanSeeTheAprrovedMessage() {

    }
}
