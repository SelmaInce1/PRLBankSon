package com.prlbank.stepdefinitions;

import com.prlbank.pages.PRLCreateOrEditACustomerPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US010_AddressStepDefinitions {

    PRLCreateOrEditACustomerPage prlCreateOrEditACustomerPage=new PRLCreateOrEditACustomerPage();

    @Then("user clicks on address text box on customer page and click any other places")
    public void user_clicks_on_address_text_box_on_customer_page_and_click_any_other_places() {
        prlCreateOrEditACustomerPage.addressTextBox.click();
        prlCreateOrEditACustomerPage.cityTextBox.click();

    }

    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        Assert.assertTrue(prlCreateOrEditACustomerPage.errorMessage.isDisplayed());

    }

    @Then("user provides an address to address text box")
    public void user_provides_an_address_to_address_text_box() {
        prlCreateOrEditACustomerPage.addressTextBox.sendKeys("address");
    }

    @Then("user should not see error message")
    public void user_should_not_see_error_message() {
        Assert.assertFalse(prlCreateOrEditACustomerPage.verifyElementNotDisplayed());
    }

    @Then("user clicks on city text box on customer page and click any other places")
    public void user_clicks_on_city_text_box_on_customer_page_and_click_any_other_places() {
        prlCreateOrEditACustomerPage.cityTextBox.click();
        prlCreateOrEditACustomerPage.addressTextBox.click();
    }

    @Then("user provides a city to city text box")
    public void user_provides_a_city_to_city_text_box() {
        prlCreateOrEditACustomerPage.cityTextBox.sendKeys("city");
    }

    @Then("user clicks on country dropdown on customer page and click any other places")
    public void user_clicks_on_country_dropdown_on_customer_page_and_click_any_other_places() {
        prlCreateOrEditACustomerPage.multiSelectDDCountry.click();

    }

    @Then("user provides a country to country DD")
    public void user_provides_a_country_to_country_dd() {

    }

    @Then("user clicks on state text box on customer page and click any other places")
    public void user_clicks_on_state_text_box_on_customer_page_and_click_any_other_places() {

    }

    @Then("user provides a state to state text box")
    public void user_provides_a_state_to_state_text_box() {

    }



}
