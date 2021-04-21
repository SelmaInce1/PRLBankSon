package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLRegistrationPage {

    public PRLRegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "ssn")
    public WebElement SSNTextBox;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    public WebElement lastNameTextBox;

    @FindBy(id = "address")
    public WebElement addressTextBox;

    @FindBy(id = "mobilephone")
    public WebElement mobilePhoneNumberTextBox;

    @FindBy(id = "username")
    public WebElement userNameTextBox;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(xpath = "//*[text() ='This field is invalid']")
    public WebElement invalidEmailError;

    @FindBy(id = "firstPassword")
    public WebElement newPasswordTextBox;

    @FindBy(id = "secondPassword")
    public WebElement passwordConfirmationTextBox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[contains(text(),'Registration saved!')]")
    public WebElement approvalAlert;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement confirmationPasswordErrorMessage;

    @FindBy(xpath = "(//div[@class=‘invalid-feedback’])[2]")
    public WebElement firstNameErrorMessage;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public WebElement red_strengthBar;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);']")
    public WebElement orange_strengthBar;

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);']")
    public WebElement green_strengthBar;

    @FindBy(xpath = "//li[4][@style='background-color: rgb(221, 221, 221);']")
    public WebElement blank4_strengthBar;

    @FindBy(xpath = "//li[5][@style='background-color: rgb(221, 221, 221);']")
    public WebElement blank5_strengthBar;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div")
    public WebElement alert;

    @FindBy(xpath = "//div[text()='This field is invalid']")
    public WebElement emailIsNotValidMessage;

    @FindBy(xpath = "//div[text()='Your SSN is invalid']")
    public WebElement SSNIsNotValidMessage;

    @FindBy(xpath = "//div[text()='Your mobile phone number is invalid']")
    public WebElement MobilePhoneIsNotValidMessage;

    public boolean verifyElementNotDisplayed(WebElement element){
        try{
            return(element.isDisplayed());
        }catch (Exception e){
            return false;
        }
    }


}
