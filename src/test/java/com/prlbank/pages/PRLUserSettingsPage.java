package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PRLUserSettingsPage {

    public PRLUserSettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "firstName")
    public WebElement FirstNameTextBox;

    @FindBy(id = "lastName")
    public WebElement LastNameTextBox;

    @FindBy(id = "email")
    public WebElement EmailTextBox;

    @FindBy(id = "langKey")
    public WebElement LanguageDD;

    @FindBy (xpath = "//select[@name='langKey']")
    public WebElement langauageDropDown;

//    @FindBy(xpath = "(//select[@id])//option[@value='tr']")
//    public WebElement turkishLang;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SaveButton;


    @FindBy(xpath = "//*[text()='This field is invalid']")
    public WebElement emailError;

    @FindBy(xpath = "//*[contains(text(),‘Setting saved!’)]")
    public WebElement EmailsuccessMessage;

    @FindBy(xpath = "//*[text()='Settings saved!']")
    public WebElement settingSaved;

    public void selectLanguage(String type) {
        Select languages = new Select(langauageDropDown);
        languages.selectByVisibleText(type);
    }
    public boolean verifyElementNotDisplayed(WebElement element){
        try{
            return(element.isDisplayed());
        }catch (Exception e){
            return false;
        }
    }
}

