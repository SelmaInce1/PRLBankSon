package com.prlbank.stepdefinitions;

import com.prlbank.pages.*;
import com.prlbank.utilities.BrowserUtils;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.BreakIterator;
import java.util.List;

public class DEMO {
    PRLRegistrationPage prlRegistrationPage  = new PRLRegistrationPage();
    PRLHomePage prlHomePage = new PRLHomePage();
    PRLSignInPage prlSignInPage = new PRLSignInPage();
    PRLAdminHomePage prlAdminHomePage = new PRLAdminHomePage();
    PRLEmployeePage prlEmployeePage = new PRLEmployeePage();
    PRLCustomersPage prlCustomersPage = new PRLCustomersPage();
    PRLCreateOrEditACustomerPage prlCreateOrEditACustomerPage = new PRLCreateOrEditACustomerPage();
    PRLCreateOrEditAnAccountPage prlCreateOrEditAnAccountPage = new PRLCreateOrEditAnAccountPage();
    PRLAccountsPage prlAccountsPage = new PRLAccountsPage();
    PRLUserPage prlUserPage = new PRLUserPage();


    @And("user provides information for registration")
    public void userProvidesInformationForRegistration() {
        Driver.wait(3);
        prlRegistrationPage.SSNTextBox.sendKeys(ConfigurationReader.getProperty("demossn"));
        Driver.wait(2);
        prlRegistrationPage.firstNameTextBox.sendKeys(ConfigurationReader.getProperty("demofname"));
        Driver.wait(2);
        prlRegistrationPage.lastNameTextBox.sendKeys(ConfigurationReader.getProperty("demolname"));
        Driver.wait(2);
        prlRegistrationPage.addressTextBox.sendKeys(ConfigurationReader.getProperty("demoaddress"));
        Driver.wait(2);
        prlRegistrationPage.mobilePhoneNumberTextBox.sendKeys(ConfigurationReader.getProperty("demomobile"));
        Driver.wait(2);
        prlRegistrationPage.userNameTextBox.sendKeys(ConfigurationReader.getProperty("demousername"));
        Driver.wait(2);
        prlRegistrationPage.emailTextBox.sendKeys(ConfigurationReader.getProperty("demoemail"));
        Driver.wait(2);
        prlRegistrationPage.newPasswordTextBox.sendKeys(ConfigurationReader.getProperty("demopswd"));
        Driver.wait(2);
        prlRegistrationPage.passwordConfirmationTextBox.sendKeys(ConfigurationReader.getProperty("demopswd"));
        Driver.wait(2);
        prlRegistrationPage.registerButton.click();

    }

    @Then("admin user clicks sign in button")
    public void userClicksSignInButton() {
        Driver.wait(3);
        prlHomePage.icon.click();
        Driver.wait(2);
        prlHomePage.signInButton.click();
    }

    @And("login to admin account {string} and {string}")
    public void loginToAdminAccountAnd(String adminusername, String adminpaswd) {
        Driver.wait(3);
        prlSignInPage.usernameTextBox.clear();
        prlSignInPage.usernameTextBox.sendKeys(adminusername);
        Driver.wait(2);
        prlSignInPage.passwordTextBox.clear();
        prlSignInPage.passwordTextBox.sendKeys(adminpaswd);
        Driver.wait(2);
        prlSignInPage.signInButton.click();

    }

    @Then("admin activates the account of the user")
    public void adminActivatesTheAccountOfTheUser() {
        Driver.wait(3);
        prlAdminHomePage.administrationDD.click();
        Driver.wait(2);
        prlAdminHomePage.userManagementLink.click();
        Driver.wait(2);
        prlAdminHomePage.createDateButton.click();
        Driver.wait(2);
        prlAdminHomePage.editButton.click();
        Driver.wait(2);
        prlAdminHomePage.activateButton.click();
        Driver.wait(3);
        prlAdminHomePage.saveButton.click();

    }

    @And("login out from admin account")
    public void loginOutFromAdminAccount() {
        Driver.wait(3);
        prlAdminHomePage.iconButton.click();
        Driver.wait(2);
        prlAdminHomePage.signOutLink.click();
    }

    @Then("login to employee account {string} and {string}")
    public void loginToEmployeeAccountAnd(String arg0, String arg1) {
        Driver.wait(3);
        prlHomePage.icon.click();
        Driver.wait(2);
        prlHomePage.signInButton.click();
        Driver.wait(2);
        prlSignInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("emplUsername"));
        Driver.wait(2);
        prlSignInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("emplPaswd"));
        Driver.wait(2);
        prlSignInPage.signInButton.click();
    }

    @And("employee integrates accounts for the user")
    public void employeeIntegratesAccountsForTheUser() {
        Driver.wait(2);
        prlEmployeePage.MyOperations.click();
        Driver.wait(2);
        prlEmployeePage.ManageAccounts.click();
        Driver.wait(2);
        prlAccountsPage.createANewAccountButton.click();
        Driver.wait(2);
        prlCreateOrEditAnAccountPage.descriptionTextBox.sendKeys("TEAM43 CHECKING");
        Driver.wait(2);
        prlCreateOrEditAnAccountPage.balanceTextBox.sendKeys("337300000");
        Driver.wait(2);
        prlCreateOrEditAnAccountPage.saveButton.click();
        Driver.wait(3);

        prlEmployeePage.MyOperations.click();
        Driver.wait(2);
        prlEmployeePage.ManageAccounts.click();
        Driver.wait(2);
        prlCustomersPage.createANewCustomerButton.click();
        Driver.wait(2);
        prlCreateOrEditAnAccountPage.descriptionTextBox.sendKeys("TEAM43 SAVING");
        Driver.wait(2);
        prlCreateOrEditAnAccountPage.balanceTextBox.sendKeys("900000");
        Driver.wait(2);
        prlCreateOrEditAnAccountPage.saveButton.click();
        Driver.wait(3);

        prlEmployeePage.MyOperations.click();
        Driver.wait(2);
        prlEmployeePage.ManageCustomers.click();
        Driver.wait(2);
        prlEmployeePage.createANewCustomerButton.click();
        Driver.wait(3);
        prlCreateOrEditACustomerPage.searchSsnTextBox.sendKeys(ConfigurationReader.getProperty("demossn"));
        Driver.wait(2);
        prlCreateOrEditACustomerPage.searchButton.click();
        Driver.wait(2);
        prlCreateOrEditACustomerPage.middleInitialTextBox.sendKeys("MI");
        Driver.wait(2);
        prlCreateOrEditACustomerPage.phoneNumberTextBox.sendKeys(ConfigurationReader.getProperty("demomobile"));
        Driver.wait(2);
        prlCreateOrEditACustomerPage.zipCodeTextBox.sendKeys("34100");
        Driver.wait(2);
        prlCreateOrEditACustomerPage.cityTextBox.sendKeys("Istanbul");
        Driver.wait(2);
        BrowserUtils.selectDdValue(prlCreateOrEditACustomerPage.multiSelectDDCountry,"TURKEY");
        Driver.wait(2);
        prlCreateOrEditACustomerPage.stateTextBox.sendKeys("TURKEY");
        Driver.wait(2);
        prlCreateOrEditACustomerPage.savingAcc.click();
        Driver.wait(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.LEFT_CONTROL).perform();
        Driver.wait(2);
        prlCreateOrEditACustomerPage.checkingAcc.click();
        actions.keyUp(Keys.LEFT_CONTROL).perform();
        prlCreateOrEditACustomerPage.saveButton.click();

//        prlEmployeePage.MyOperations.click();
//        prlEmployeePage.ManageCustomers.click();
//        prlCreateOrEditACustomerPage.ssnTextBox.sendKeys(ConfigurationReader.getProperty("demossn"));
//        Driver.wait(2);
//        prlCreateOrEditACustomerPage.searchButton.click();
//        prlCreateOrEditACustomerPage.middleInitialTextBox.sendKeys("MI");
//        prlCreateOrEditACustomerPage.phoneNumberTextBox.sendKeys(ConfigurationReader.getProperty("demomobile"));
//        prlCreateOrEditACustomerPage.zipCodeTextBox.sendKeys("34100");
//        prlCreateOrEditACustomerPage.cityTextBox.sendKeys("Istanbul");
//        BrowserUtils.selectDdValue(prlCreateOrEditACustomerPage.multiSelectDDCountry,"TURKEY");
//        prlCreateOrEditACustomerPage.stateTextBox.sendKeys("TURKEY");
//        prlCreateOrEditACustomerPage.checkingAcc.click();
//        prlCreateOrEditACustomerPage.saveButton.click();

    }

    @Then("login out from employee account")
    public void loginOutFromEmployeeAccount() {
        Driver.wait(3);
        prlAccountsPage.iconMenu.click();
        Driver.wait(2);
        prlAccountsPage.signOutButton.click();
    }

    @Then("user logs into their own account")
    public void userLogsIntoTheirOwnAccount() {
        Driver.wait(3);
        prlHomePage.icon.click();
        Driver.wait(2);
        prlHomePage.signInButton.click();
        Driver.wait(2);
        prlSignInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("demousername"));
        Driver.wait(2);
        prlSignInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("demopswd"));
        Driver.wait(2);
        prlSignInPage.signInButton.click();
    }


    @And("user navigates to My Operations")
    public void userNavigatesToMyOperations() {
        Driver.wait(3);
        prlUserPage.MyOperations.click();
    }

    @Then("user makes money transfer")
    public void userMakesMoneyTransfer() {
        Driver.wait(3);
        prlUserPage.TransferMoney.click();
        //prlUserPage.fromAccount.sendKeys(ConfigurationReader.getProperty("fromTextbox"));
        Driver.wait(2);
        Select select = new Select(prlUserPage.fromAccount);
        Select select1 = new Select(prlUserPage.toAccount);
        select.selectByIndex(2);
        Driver.wait(2);
        select1.selectByIndex(1);
        Driver.wait(2);
        //prlUserPage.toAccount.sendKeys(ConfigurationReader.getProperty("toTextbox"));
        Driver.wait(2);
        prlUserPage.balanceTextBox.sendKeys(ConfigurationReader.getProperty("balanceTextBox"));
        Driver.wait(2);
        prlUserPage.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("descriptionTextBox"));
        Driver.wait(2);
        prlUserPage.MakeTransferButton.click();
        Driver.wait(2);
    }

    @And("user verifies their money transfer")
    public void userVerifiesTheirMoneyTransfer() {


    }
}
