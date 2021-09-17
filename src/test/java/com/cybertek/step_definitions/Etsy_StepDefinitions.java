package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Etsy_StepDefinitions {

    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {

        String url = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(url);
    }

    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
    }

    @When("user searches for {string}")
    public void userSearchesFor(String arg0) {
        EtsySearchPage etsySearchPage = new EtsySearchPage();
        etsySearchPage.searchBox.sendKeys(arg0 + Keys.ENTER);
    }

    @Then("user should see {string} in the Etsy Title")
    public void userShouldSeeInTheEtsyTitle(String arg0) {

        String actual = Driver.getDriver().getTitle();
        String expected = arg0+" | Etsy";

        Assert.assertEquals(actual, expected);

    }
}
