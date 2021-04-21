package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLManagerHomePage {

    public PRLManagerHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "entity-menu")
    public WebElement myOperationsDropdown;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[1]/span")
    public WebElement manageCustomer;

    @FindBy(xpath ="//*[text()='Manage Accounts']")
    public WebElement manageAccounts;
}
