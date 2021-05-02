package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLCustomerPasswordPage {
    public PRLCustomerPasswordPage () { PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[text()='Password']")
    public WebElement customerPassword;

    @FindBy (xpath = "//*[text()='Customer1 Customer']")
    public WebElement customerIcon;

    @FindBy (id = "currentPassword")
    public WebElement currentPasswordBox;

    @FindBy(xpath = "//*[text()='Password changed!']")
    public WebElement passwordChanged;

    @FindBy(xpath = "//*[text()='Wrong Element!']")
    public WebElement passwordChangedError;

    @FindBy(id = "newPassword")
    public WebElement newPasswordBox;

    @FindBy(xpath = "//*[@id=\"strengthBar\"]/li[5]")
    public WebElement strengthBar5;

    @FindBy (id = "confirmPassword")
    public WebElement passwordConfirmationBox;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement SaveButton;

    public boolean verifyElementNotDisplayed(WebElement element){
        try{
            return(element.isDisplayed());
        }catch (Exception e){
            return false;
        }
    }





}
