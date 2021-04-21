package com.prlbank.stepdefinitions;
import com.prlbank.pages.PRLHomePage;
import com.prlbank.pages.PRLRegistrationPage;
import com.prlbank.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import javax.security.auth.login.Configuration;

public class US007StepDefinitions {

    PRLRegistrationPage prlRegistrationPage = new PRLRegistrationPage();
    PRLHomePage prlHomePage = new PRLHomePage();

    @And("User clicks on email textbox")
    public void userClicksOnEmailTextbox() {
        prlRegistrationPage.emailTextBox.click();
    }

    @And("User enters an invalid email")
    public void userEntersAnInvalidEmail() {
     prlRegistrationPage.emailTextBox.sendKeys(ConfigurationReader.getProperty("invalid_email"));
    }

    @Then("user should see the error message")
    public void userShouldSeeTheErrorMessage() {
        //Assert.assertEquals(prlRegistrationPage.invalidEmailError.getText(),"This field is invalid");
        Assert.assertTrue(prlRegistrationPage.firstNameErrorMessage.isDisplayed());
    }

    @Then("User can not enter data in only  English and Turkish languages, so the user can not enter data on other languges")
    public void userCanNotEnterDataInOnlyEnglishAndTurkishLanguagesSoTheUserCanNotEnterDataOnOtherLanguges() {
        prlRegistrationPage.userNameTextBox.sendKeys(ConfigurationReader.getProperty("french"));
        Assert.assertFalse(prlRegistrationPage.firstNameErrorMessage.isDisplayed());
    }
}
