package com.prlbank.pages;

import com.prlbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PRLCustomersPage {

    public PRLCustomersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="jh-create-entity")
    public WebElement createANewCustomerButton;



}
