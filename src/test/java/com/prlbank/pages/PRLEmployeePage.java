package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLEmployeePage {

    public PRLEmployeePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='My Operations']")
    public WebElement MyOperations;

    @FindBy(xpath = "//*[text()='Manage Customers']")
    public WebElement ManageCustomers;

    @FindBy(xpath = "//*[text()='Manage Accounts']")
    public WebElement ManageAccounts;

    @FindBy(xpath="//*[text()='Create a new Customer']")
    public WebElement createANewCustomerButton;


}
