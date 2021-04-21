package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLResetPasswordPage {

    public PRLResetPasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement resetPasswordBtn;

    @FindBy(xpath = "//*[text()='Reset your password']")
    public WebElement resetText;


}
