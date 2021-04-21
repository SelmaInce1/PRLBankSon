package com.prlbank.pages;


import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLHomePage {

    public PRLHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//*[text() ='Register']")
    public WebElement register;

    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement icon;

    @FindBy(xpath = "(//*[text()='Sign in'])[1]")
    public WebElement signInButton;

//    @FindBy(id = "account-menu")
//    public WebElement iconMenu;


    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButton;


}
