package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLAccountsPage {

    public PRLAccountsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="jh-create-entity")
    public WebElement createANewAccountButton;

    @FindBy(id = "account-menu")
    public WebElement iconMenu;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOutButton;

}
