package com.prlbank.stepdefinitions;

import com.prlbank.pages.PRLHomePage;
import com.prlbank.pages.PRLSignInPage;
import com.prlbank.pages.PRLUserSettingsPage;
import com.prlbank.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.security.auth.login.Configuration;
import java.util.List;

public class US007StepDefinitions {
    PRLHomePage prlHomePage = new PRLHomePage();
    PRLSignInPage prlSignInPage = new PRLSignInPage();
    PRLUserSettingsPage prlUserSettingsPage = new PRLUserSettingsPage();

    @And("User clicks on email text box")
    public void userClicksOnEmailTextBox() {
        prlUserSettingsPage.EmailTextBox.click();
    }

    @And("User enters an invalid email without @ sign to email text box")
    public void userEntersAnInvalidEmailWithoutSignToEmailTextBox() {
        prlUserSettingsPage.EmailTextBox.clear();
        prlUserSettingsPage.EmailTextBox.sendKeys(ConfigurationReader.getProperty("invalid_customer_email1"));
    }

    @Then("user should see the error message for email")
    public void userShouldSeeTheErrorMessageForEmail() {
        Assert.assertTrue(prlUserSettingsPage.emailError.isDisplayed());
    }

    @And("User enters a valid email with extensions to email text box")
    public void userEntersAValidEmailWithExtensionsToEmailTextBox() {
        prlUserSettingsPage.EmailTextBox.clear();
        prlUserSettingsPage.EmailTextBox.sendKeys(ConfigurationReader.getProperty("valid_customer_email"));

    }
    @Then("user should not see the error message for email")
    public void userShouldNotSeeTheErrorMessageForEmail() {
        Assert.assertFalse(prlUserSettingsPage.verifyElementNotDisplayed(prlUserSettingsPage.emailError));
    }

    @And("User can enter data in only  English and Turkish languages, so the user can not enter data on other languages")
    public void userCanEnterDataInOnlyEnglishAndTurkishLanguagesSoTheUserCanNotEnterDataOnOtherLanguages() {
        Select select = new Select(prlUserSettingsPage.langauageDropDown);
        List<WebElement> options = select.getOptions();
        String elements = options.get(0).getText() + options.get(1).getText();
        Assert.assertTrue(options.size()==2);
        Assert.assertTrue( elements.contains("English"));
        Assert.assertTrue( elements.contains("Turkish"));

    }
//    Select select=new Select(categoriesDD);
//    List<WebElement> options=select.getOptions();
//    for (WebElement option:options){
//    String optionText=option.getText();
//    System.out.println(optionText);
}

