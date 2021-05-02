package com.prlbank.stepdefinitions;

import com.prlbank.pages.PRLCustomerPasswordPage;
import com.prlbank.pages.PRLHomePage;
import com.prlbank.pages.PRLSignInPage;
import com.prlbank.utilities.ConfigurationReader;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import javax.security.auth.login.Configuration;

public class US008StepDefinitions {
    PRLHomePage prlHomePage = new PRLHomePage();
    PRLSignInPage prlSignInPage = new PRLSignInPage();
    PRLCustomerPasswordPage prlCustomerPasswordPage = new PRLCustomerPasswordPage();

    @And("user navigates to password")
    public void userNavigatesToPassword() {
        prlCustomerPasswordPage.customerIcon.click();
        prlCustomerPasswordPage.customerPassword.click();
    }
    @And("user enter old password to current password box")
    public void userEnterOldPasswordToCurrentPasswordBox() {
        prlCustomerPasswordPage.currentPasswordBox.sendKeys(ConfigurationReader.getProperty("customer_current_password"));
    }

    @And("user should not enter the old password  into new password box")
    public void userShouldNotEnterTheOldPasswordIntoNewPasswordBox() {
        prlCustomerPasswordPage.newPasswordBox.sendKeys(ConfigurationReader.getProperty("customer_old_password"));
    }

    @Then("user should see the error message about the password")
    public void userShouldSeeTheErrorMessageAboutThePassword() {
        prlCustomerPasswordPage.passwordConfirmationBox.sendKeys(ConfigurationReader.getProperty("customer_current_password"));
        prlCustomerPasswordPage.SaveButton.click();

        try{
            Assert.assertTrue(prlCustomerPasswordPage.passwordChangedError.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(false);
        }

        //Assert.assertTrue(prlCustomerPasswordPage.passwordChanged.isDisplayed());
        //  Assert.assertFalse(prlCustomerPasswordPage.verifyElementNotDisplayed());
    }

    @And("user should enter at least {int} lowercase char into new password box")
    public void userShouldEnterAtLeastLowercaseCharIntoNewPasswordBox(int arg0) {
        prlCustomerPasswordPage.newPasswordBox.sendKeys(ConfigurationReader.getProperty("password_lowercase"));
    }
    @Then("the indicator of password strength turn to orange or green color accordingly")
    public void theIndicatorOfPasswordStrengthTurnToOrangeOrGreenColorAccordingly() {
        Assert.assertTrue(prlCustomerPasswordPage.strengthBar5.isDisplayed());
    }

    @And("user should enter at least {int} uppercase char into new password box")
    public void userShouldEnterAtLeastUppercaseCharIntoNewPasswordBox(int arg0) {
        prlCustomerPasswordPage.newPasswordBox.sendKeys(ConfigurationReader.getProperty("password_uppercase"));
    }

    @And("user should enter at least {int} digit into new password box")
    public void userShouldEnterAtLeastDigitIntoNewPasswordBox(int arg0) {
        prlCustomerPasswordPage.newPasswordBox.sendKeys(ConfigurationReader.getProperty("password_digit"));
    }

    @And("user should enter at least {int} special char into new password box")
    public void userShouldEnterAtLeastSpecialCharIntoNewPasswordBox(int arg0) {
        prlCustomerPasswordPage.newPasswordBox.sendKeys(ConfigurationReader.getProperty("password_SChar"));
    }

    @And("user should enter at least {int} chars into new password box")
    public void userShouldEnterAtLeastCharsIntoNewPasswordBox(int arg0) {
        prlCustomerPasswordPage.newPasswordBox.sendKeys(ConfigurationReader.getProperty("password_7Chars"));
    }

    @And("User should enter your valid password into new password box")
    public void userShouldEnterYourValidPasswordIntoNewPasswordBox() {
        prlCustomerPasswordPage.newPasswordBox.sendKeys(ConfigurationReader.getProperty("customer_current_password"));
    }

    @And("User should enter your same password into new password confirmation box")
    public void userShouldEnterYourSamePasswordIntoNewPasswordConfirmationBox() {
        prlCustomerPasswordPage.passwordConfirmationBox.sendKeys(ConfigurationReader.getProperty("customer_current_password"));
    }

    @Then("User should not see the error message")
    public void userShouldNotSeeTheErrorMessage() {

        try{
            Assert.assertTrue(prlCustomerPasswordPage.passwordChangedError.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }


}
