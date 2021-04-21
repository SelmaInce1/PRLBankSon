package com.prlbank.stepdefinitions;

import com.prlbank.pages.*;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class US013_CreateNewAccount_StepDef {

    PRLHomePage homePage = new PRLHomePage();
    PRLSignInPage signInPage = new PRLSignInPage();
    PRLManagerHomePage managerPage = new PRLManagerHomePage();
    PRLAccountsPage accountsPage = new PRLAccountsPage();
    PRLCreateOrEditAnAccountPage createAccount = new PRLCreateOrEditAnAccountPage();



    @Given("User navigates to sign in page")
    public void userNavigatesToSignInPage() {
        Driver.wait(1);
        homePage.icon.click();
        Driver.wait(1);
        homePage.signInButton.click();


    }

    @Given("User clicks on Username textbox and provide a username {string}")
    public void userClicksOnUsernameTextboxAndProvideAUsername(String arg0) {

        Driver.wait(1);
        signInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("manager_username"));

    }

    @Given("User clicks on Password textbox and provide a password {string}")
    public void userClicksOnPasswordTextboxAndProvideAPassword(String arg0) {

        Driver.wait(1);
        signInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("manager_password"));

    }


    @And("User clicks on Sign in button")
    public void userClicksOnSignInButton() {

        Driver.wait(1);
        signInPage.signInButton.click();

    }

    @Then("User clicks on My Operations and navigates to Manage Accounts page")
    public void userClicksOnMyOperationsAndNavigatesToManageAccountsPage() {

        Driver.wait(1);
        managerPage.myOperationsDropdown.click();
        managerPage.manageAccounts.click();

    }

    @And("User clicks the button to create new account")
    public void userClicksTheButtonToCreateNewAccount() {

        accountsPage.createANewAccountButton.click();
    }

    @Given("User clicks on Description textbox and provide a {string}")
    public void userClicksOnDescriptionTextboxAndProvideA(String arg0) {

        createAccount.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("user_description"));
        Driver.wait(1);
        createAccount.balanceTextBox.click();
    }

    @Then("there should not be any error message")
    public void thereShouldNotBeAnyErrorMessage() {
        Driver.wait(1);
        Assert.assertTrue(createAccount.invalidFeedback.isEmpty());

    }

    @Given("User leaves the description textbox blank")
    public void userLeavesTheDescriptionTextboxBlank() {
        createAccount.descriptionTextBox.click();
        Driver.wait(1);
        createAccount.balanceTextBox.click();


    }

    @Then("there should be error message")
    public void thereShouldBeErrorMessage() {
        Driver.wait(1);
        Assert.assertEquals("This field is required.",createAccount.invalidFeedback.get(0).getText());

    }

    @And("User provide a valid balance {string}")
    public void userProvideAValidBalance(String arg0) {
        Driver.wait(1);
        createAccount.balanceTextBox.sendKeys(ConfigurationReader.getProperty("valid_balance"));
        createAccount.multiSelectDDAccountType.click();
    }


    @Then("there should not be any error message saying that this field should be a number")
    public void thereShouldNotBeAnyErrorMessageSayingThatThisFieldShouldBeANumber() {
        Driver.wait(1);
        Assert.assertTrue(createAccount.invalidFeedback.isEmpty());
    }

    @And("User provide an invalid balance {string}")
    public void userProvideAnInvalidBalance(String arg0) {
        Driver.wait(1);
        createAccount.balanceTextBox.sendKeys(ConfigurationReader.getProperty("invalid_balance"));
        createAccount.multiSelectDDAccountType.click();
    }

    @Then("there should be an error message saying that this field should be a number")
    public void thereShouldBeAnErrorMessageSayingThatThisFieldShouldBeANumber() {
        Driver.wait(1);
        Assert.assertEquals("This field should be a number.",createAccount.invalidFeedback.get(0).getText());
    }

    @Then("User clicks on Balance textbox and leaves the balance textbox blank")
    public void userClicksOnBalanceTextboxAndLeavesTheBalanceTextboxBlank() {
        Driver.wait(1);
        createAccount.balanceTextBox.click();
        createAccount.multiSelectDDAccountType.click();
    }

    @Then("there should be an error message saying that this field is required")
    public void thereShouldBeAnErrorMessageSayingThatThisFieldIsRequired() {
        Driver.wait(1);
        Assert.assertEquals("This field is required.",createAccount.invalidFeedback.get(0).getText());
    }

    @Given("User clicks on Account Type and select an account type")
    public void userClicksOnAccountTypeAndSelectAnAccountType() {
         createAccount.selectAccountType("SAVING");
    }

    @Then("Selected account type should be displayed on the box")
    public void selectedAccountTypeShouldBeDisplayedOnTheBox() {
        Assert.assertTrue("SAVING", createAccount.multiSelectDDAccountType.isDisplayed());
    }

    @Given("User clicks on Account Status type and select a type")
    public void userClicksOnAccountStatusTypeAndSelectAType() {
        createAccount.selectAccountStatusType("CLOSED");
    }

    @Then("Selected Account status type should be displayed on the box")
    public void selectedAccountStatusTypeShouldBeDisplayedOnTheBox() {
        Assert.assertTrue("CLOSED", createAccount.multiSelectDDAccountStatusType.isDisplayed());
    }

    @Given("User clicks on Employee dropdown")
    public void userClicksOnEmployeeDropdown() {
        createAccount.multiSelectDDEmployee.click();
    }

    @Then("there should be the employee names on the dropdown list")
    public void thereShouldBeTheEmployeeNamesOnTheDropdownList() {
        String manager ="Manager";
        Assert.assertFalse(createAccount.selectEmployee().toString().contains(manager));
    }



}