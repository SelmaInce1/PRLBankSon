package com.prlbank.stepdefinitions;

import com.prlbank.pages.*;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US009_StepDefinitions {

    PRLHomePage prlHomePage= new PRLHomePage();
    PRLSignInPage prlSignInPage=new PRLSignInPage();
    PRLManagerHomePage prlManagerHomePage=new PRLManagerHomePage();
    PRLCustomersPage prlCustomersPage=new PRLCustomersPage();
    PRLCreateOrEditACustomerPage prlCreateOrEditACustomerPage=new PRLCreateOrEditACustomerPage();

    @Then("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        prlHomePage.signInButton.click();
    }

    @Then("user provides a valid username as manager to username textbox")
    public void user_provides_a_valid_username_as_manager_to_username_textbox() {
        prlSignInPage.usernameTextBox.sendKeys("team43manager");
    }

    @Then("user provides a valid password as manager password to password textbox")
    public void user_provides_a_valid_password_as_manager_password_to_password_textbox() {
        prlSignInPage.passwordTextBox.sendKeys("T43manager.");
    }

    @Then("user clicks on my operations button")
    public void user_clicks_on_my_operations_button() {
        prlSignInPage.signInButton.click();
    }

    @Then("user clicks on manage customers dropdown")
    public void user_clicks_on_manage_customers_dropdown() {
        prlManagerHomePage.myOperationsDropdown.click();
        prlManagerHomePage.manageCustomer.click();
        Driver.wait(3);
    }

    @Then("user clicks on create a new customer button on customers page")
    public void user_clicks_on_create_a_new_customer_button_on_customers_page() {
        prlCustomersPage.createANewCustomerButton.click();
    }

    @Then("user provides a valid SSN number to SSn text box on create or edit a customer page")
    public void user_provides_a_valid_ssn_number_to_s_sn_text_box_on_create_or_edit_a_customer_page() {
        prlCreateOrEditACustomerPage.searchSsnTextBox.sendKeys("123-45-6789");
    }

    @Then("user clicks on search button")
    public void user_clicks_on_search_button() {
        prlCreateOrEditACustomerPage.searchButton.click();
    }

    @Then("user should see customers' registration info populated")
    public void user_should_see_customers_registration_info_populated() {
        Assert.assertEquals(prlCreateOrEditACustomerPage.firstNameTextBox.getText(),"settar");

    }




}
