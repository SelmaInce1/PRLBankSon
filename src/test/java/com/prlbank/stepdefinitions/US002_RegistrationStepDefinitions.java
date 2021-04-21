package com.prlbank.stepdefinitions;

import com.prlbank.pages.PRLHomePage;
import com.prlbank.pages.PRLRegistrationPage;
import com.prlbank.utilities.ConfigurationReader;
import com.prlbank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class US002_RegistrationStepDefinitions {

    PRLHomePage prlHomePage= new PRLHomePage();
    PRLRegistrationPage prlRegistrationPage= new PRLRegistrationPage();

    @Given("user is on main page")
    public void userIsOnMainPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("prlbank_url"));

    }
    @When("user clicks to icon menu")
    public void userClicksToIconMenu() {
        Driver.waitAndClick(prlHomePage.icon, 5);
    }
    @Then("user clicks on register button")
    public void user_clicks_on_register_button() {
        prlHomePage.registerButton.click();
    }

    @When("user clicks on SSN text box and provide an SSN number")
    public void user_clicks_on_ssn_text_box_and_provide_an_ssn_number() {
        prlRegistrationPage.SSNTextBox.sendKeys("676-08-9442");
    }

    @Then("user clicks on first name text box and provide a first name")
    public void user_clicks_on_first_name_text_box_and_provide_a_first_name() {
        prlRegistrationPage.firstNameTextBox.sendKeys("firstname");
    }

    @Then("user clicks on last name text box and provide a last name")
    public void user_clicks_on_last_name_text_box_and_provide_a_last_name() {
        prlRegistrationPage.lastNameTextBox.sendKeys("lastname");
    }

    @Then("user clicks on address text box and provide an address")
    public void user_clicks_on_address_text_box_and_provide_an_address() {
        prlRegistrationPage.addressTextBox.sendKeys("address");
    }

    @Then("user clicks on mobilephone text box and provide a mobile phone")
    public void user_clicks_on_mobilephone_text_box_and_provide_a_mobile_phone() {
        prlRegistrationPage.mobilePhoneNumberTextBox.sendKeys("379-732-6282");
    }

    @Then("user clicks on username and provide a username")
    public void user_clicks_on_username_and_provide_a_username() {
        prlRegistrationPage.userNameTextBox.sendKeys("username1");
    }

    @Then("user clicks on email text box and provide an email")
    public void user_clicks_on_email_text_box_and_provide_an_email() {
        prlRegistrationPage.emailTextBox.sendKeys("email@gmail.com");
    }

    @Then("user clicks on new password text box and provide a password")
    public void user_clicks_on_new_password_text_box_and_provide_a_password() {
        prlRegistrationPage.newPasswordTextBox.sendKeys("newpassword");
    }

    @Then("user clicks on new password confirmation text box and provide password confirmation")
    public void user_clicks_on_new_password_confirmation_text_box_and_provide_password_confirmation() {
        prlRegistrationPage.passwordConfirmationTextBox.sendKeys("newpassword");
    }

    @Then("user clicks on register button on registration page")
    public void user_clicks_on_register_button_on_registration_page() {
        prlRegistrationPage.registerButton.click();
    }

    @Then("user should see the approval message")
    public void user_should_see_the_approval_message() {
        Driver.wait(1);
        String alertText=prlRegistrationPage.approvalAlert.getText();
        System.out.println(alertText);
        Assert.assertEquals("Registration fail", "Registration saved!", alertText);
    }

    @Then("user leaves new password confirmation text box blanked")
    public void user_leaves_new_password_confirmation_text_box_blanked() {
        prlRegistrationPage.passwordConfirmationTextBox.sendKeys("");
    }

    @Then("user should see rejection message")
    public void user_should_see_rejection_message() {
        Assert.assertTrue(prlRegistrationPage.confirmationPasswordErrorMessage.isDisplayed());

    }

    @Then("user should not see SSN is not valid error message")
    public void user_should_not_see_ssn_is_not_valid_error_message() {
        Assert.assertFalse(prlRegistrationPage.verifyElementNotDisplayed(prlRegistrationPage.SSNIsNotValidMessage));
    }

    @When("user clicks on SSN text box and provide an invalid SSN number")
    public void user_clicks_on_ssn_text_box_and_provide_an_invalid_ssn_number() {
        prlRegistrationPage.SSNTextBox.sendKeys("123-45-678#");
    }

    @Then("user should see SSN is not valid error message")
    public void user_should_see_ssn_is_not_valid_error_message() {
        Assert.assertTrue(prlRegistrationPage.SSNIsNotValidMessage.isDisplayed());
    }

    @Then("user should not see mobile phone is not valid error message")
    public void user_should_not_see_mobile_phone_is_not_valid_error_message() {
        Assert.assertFalse(prlRegistrationPage.verifyElementNotDisplayed(prlRegistrationPage.MobilePhoneIsNotValidMessage));
    }

    @When("user clicks on mobilephone text box and provide an invalid mobile phone")
    public void user_clicks_on_mobilephone_text_box_and_provide_an_invalid_mobile_phone() {
        prlRegistrationPage.mobilePhoneNumberTextBox.sendKeys("123-456-789#");
    }

    @Then("user should see mobile phone is not valid error message")
    public void user_should_see_mobile_phone_is_not_valid_error_message() {
        Assert.assertTrue(prlRegistrationPage.MobilePhoneIsNotValidMessage.isDisplayed());

    }

    @Then("user should not see this field is invalid error message")
    public void user_should_not_see_this_field_is_invalid_error_message() {
        Assert.assertFalse(prlRegistrationPage.verifyElementNotDisplayed(prlRegistrationPage.emailIsNotValidMessage));
    }

    @Then("user clicks on email text box and provide an invalid email")
    public void user_clicks_on_email_text_box_and_provide_an_invalid_email() {
        prlRegistrationPage.emailTextBox.sendKeys("somebodygmailcom");
    }

    @Then("user should see this field is invalid error message")
    public void user_should_see_this_field_is_invalid_error_message() {
        Assert.assertTrue(prlRegistrationPage.emailIsNotValidMessage.isDisplayed());
    }


}
