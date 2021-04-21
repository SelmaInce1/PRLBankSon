package com.prlbank.pages;

import com.prlbank.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class PRLCreateOrEditACustomerPage {

    public PRLCreateOrEditACustomerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "search-ssn")
    public WebElement searchSsnTextBox;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"tp-customer-firstName\"]")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//*[@id=\"tp-customer-lastName\"]")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//*[@id=\"tp-customer-middleInitial\"]")
    public WebElement middleInitialTextBox;

    @FindBy(xpath = "//*[@id=\"tp-customer-email\"]")
    public WebElement emailTextBox;

    @FindBy(id = "tp-customer-mobilePhoneNumber")
    public WebElement mobilePhoneNumberTextBox;

    @FindBy(id = "tp-customer-phoneNumber")
    public WebElement phoneNumberTextBox;

    @FindBy(xpath = "//*[@id=\"tp-customer-zipCode\"]")
    public WebElement zipCodeTextBox;

    @FindBy(xpath = "//*[@id=\"tp-customer-address\"]")
    public WebElement addressTextBox;

    @FindBy(xpath = "//*[@id=\"tp-customer-city\"]")
    public WebElement cityTextBox;

    @FindBy(id = "tp-customer-ssn")
    public WebElement ssnTextBox;

    @FindBy(id = "tp-customer-createDate")
    public WebElement createDateSelect;

    @FindBy(id = "tp-customer-country")
    public WebElement multiSelectDDCountry;

    @FindBy(id = "tp-customer-state")
    public WebElement stateTextBox;

    @FindBy(id = "tp-customer-user")
    public WebElement multiSelectDDUser;

    @FindBy(xpath = "//select[@id='tp-customer-account']")
    public WebElement multiSelectAccount;

    @FindBy(id = "tp-customer-zelleEnrolled")
    public WebElement zelleEnrolledCheckBox;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(id = "cancel-save")
    public WebElement backArrowButton;

    @FindBy(xpath = "//*[text()='This field is required.']")
    public WebElement errorMessage;

    @FindBy(xpath = "(//*[text()='TEAM43 CHECKING'])[1]")
    public WebElement checkingAcc;

    @FindBy(xpath = "(//*[text()='TEAM43 SAVING'])[1]")
    public WebElement savingAcc;


    public boolean verifyElementNotDisplayed(){
        try{
            return(errorMessage.isDisplayed());
        }catch (Exception e){
            return false;
        }
    }

}
