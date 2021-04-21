package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PRLAdminHomePage {
    public PRLAdminHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "admin-menu")
    public WebElement administrationDD;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagementLink;

    @FindBy(xpath = "//*[text()='team43 Checking Account']")
    public WebElement checkingAccountName;

    @FindBy(xpath = "//*[text()='team43 Saving Account']")
    public WebElement savingAccountName;

    @FindBy(xpath = "//*[@id=“demo43username4”]/td[4]/button")
    public WebElement deactivateButtonforUser;

    @FindBy(id = "account-menu")
    public WebElement iconButton;

    @FindBy(xpath="//*[text()='Sign out']")
    public WebElement signOutLink;

    @FindBy(xpath="//table[@class='table table-striped']/tbody/tr/td[4]")
    public List<WebElement> tableDeactivateBtn;

    @FindBy(xpath="//a[@href='/admin/user-management/demo43username001/edit']")
    public WebElement editButton;

    @FindBy(css="#app-view-container > div.jh-card.card > div > div > div > div.table-responsive > table > thead > tr > th:nth-child(7) > svg")
    public WebElement createDateButton;

    @FindBy(id="activated")
    public WebElement activateButton;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;





//    List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
//        for(int i=1;i< rows.size();i++){     //starting to loop
//        String rowText= rows.get(i).getText();      //get the text
//        System.out.println(rowText);
//        if(rowText.contains("Bob Feather")){         //setting a condition to click on checkbox
//            driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[1]")).get(i-1).click();
//            //locating all the checkboxes and grabbing a single row checkbox and click it
//            break;
//        }
//
//    }







}
