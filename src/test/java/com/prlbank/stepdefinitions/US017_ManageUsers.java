package com.prlbank.stepdefinitions;

import com.prlbank.pages.PRLAdminHomePage;
import com.prlbank.utilities.BrowserUtils;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US017_ManageUsers {
    PRLAdminHomePage prlAdminHomePage = new PRLAdminHomePage();


    @And("navigates to users page")
    public void navigatesToUsersPage() {
        Driver.waitAndClick(prlAdminHomePage.administrationDD,3);
        Driver.waitAndClick(prlAdminHomePage.userManagementLink,3);
    }

    @Then("admin selects role as a user")
    public void adminSelectsRoleAsAUser() {
        prlAdminHomePage.createDateButton.click();
        prlAdminHomePage.editButton.click();
        Driver.wait(2);
        prlAdminHomePage.activateButton.click();
        //unselect anything from dd
        BrowserUtils.selectDdValue(prlAdminHomePage.profiles,"ROLE_USER");
        Driver.waitAndClick(prlAdminHomePage.saveButton,2);
    }

    @Given("admin activates the account of the employee")
    public void adminActivatesTheAccountOfTheEmployee() {
        prlAdminHomePage.createDateButton.click();
        prlAdminHomePage.editButton.click();
        Driver.wait(2);
        prlAdminHomePage.activateButton.click();

    }

    @Then("admin selects role as an employee")
    public void adminSelectsRoleAsAnEmployee() {
        //unselect anything from dd
        BrowserUtils.selectDdValue(prlAdminHomePage.profiles,"ROLE_EMPLOYEE");
        Driver.waitAndClick(prlAdminHomePage.saveButton,2);
    }

    @Given("admin activates the account of the manager")
    public void adminActivatesTheAccountOfTheManager() {
        prlAdminHomePage.createDateButton.click();
        prlAdminHomePage.editButton.click();
        Driver.wait(2);
        prlAdminHomePage.activateButton.click();
    }

    @Then("admin selects role as a manager")
    public void adminSelectsRoleAsAManager() {
        //unselect anything from dd
        BrowserUtils.selectDdValue(prlAdminHomePage.profiles,"ROLE_MANAGER");
        Driver.waitAndClick(prlAdminHomePage.saveButton,2);
    }

    @Given("admin activates the account of the admin")
    public void adminActivatesTheAccountOfTheAdmin() {
        prlAdminHomePage.createDateButton.click();
        prlAdminHomePage.editButton.click();
        Driver.wait(2);
        prlAdminHomePage.activateButton.click();
    }

    @Then("admin selects role as an admin")
    public void adminSelectsRoleAsAnAdmin() {
        //unselect anything from dd
        BrowserUtils.selectDdValue(prlAdminHomePage.profiles,"ROLE_ADMIN");
        Driver.waitAndClick(prlAdminHomePage.saveButton,2);
    }

    @Given("admin activates the account of the customer")
    public void adminActivatesTheAccountOfTheCustomer() {
        prlAdminHomePage.createDateButton.click();
        prlAdminHomePage.editButton.click();
        Driver.wait(2);
        prlAdminHomePage.activateButton.click();
    }

    @Then("admin selects role as a customer")
    public void adminSelectsRoleAsACustomer() {
        //unselect anything from dd
        BrowserUtils.selectDdValue(prlAdminHomePage.profiles,"ROLE_CUSTOMER");
        Driver.waitAndClick(prlAdminHomePage.saveButton,2);
    }

    @Given("admin clicks view button")
    public void adminClicksViewButton() {
        Driver.waitAndClick(prlAdminHomePage.viewButton,2);
    }

    @Then("admin verifies all user info page is displayed")
    public void adminVerifiesAllUserInfoPageIsDisplayed() {
        Assert.assertTrue(prlAdminHomePage.verifyTitleName.isDisplayed());
    }

    @Given("admin clicks edit button")
    public void adminClicksEditButton() {
        prlAdminHomePage.editButton.click();
    }

    @Then("admin verifies create or edit a user page is displayed")
    public void adminVerifiesCreateOrEditAUserPageIsDisplayed() {

    }

    @Given("admin clicks delete button")
    public void adminClicksDeleteButton() {
        prlAdminHomePage.deleteButton.click();
    }

    @Then("admin verifies pop up is displayed")
    public void adminVerifiesPopUpIsDisplayed() {

    }
}
