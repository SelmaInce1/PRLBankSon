package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLUserPage {
    public PRLUserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='My Operations']")
    public WebElement MyOperations;

    @FindBy(xpath = "//*[text()='My Accounts']")
    public WebElement MyAccounts;

    @FindBy(xpath = "//*[text()='Transfer Money']")
    public WebElement TransferMoney;

    @FindBy(xpath="//*[@id=\"fromAccountId\"]")
    public WebElement fromAccount;

    @FindBy(xpath="//*[@id=\"toAccountId\"]")
    public WebElement toAccount;

    @FindBy(id = "balance")
    public WebElement balanceTextBox;

    @FindBy(id = "description")
    public WebElement descriptionTextBox;

    @FindBy(id = "make-transfer")
    public WebElement MakeTransferButton;

}

