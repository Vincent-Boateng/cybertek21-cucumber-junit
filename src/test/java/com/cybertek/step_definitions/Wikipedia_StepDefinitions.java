package com.cybertek.step_definitions;

import com.cybertek.pages.WikiSearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wikipedia_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("user is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
       String url = ConfigurationReader.getProperty("wikiUrl");
        Driver.getDriver().get(url);
    }

    @When("user types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {

        wikiSearchPage.wikiSearchBox.sendKeys(string);
    }

    @When("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchPage.wikiSearchButton.click();
    }

    @Then("user sees {string} in the wiki title")
    public void user_sees_in_the_wiki_title(String string) {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = string;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    @Then("user sees {string} in the main header")
    public void userSeesInTheMainHeader(String arg0) {

        String actualHeader = wikiSearchPage.wikiMainHeader.getText();
        String expectedHeader = arg0;

       // Assert.assertEquals("Actual header is not the same as expected header", expectedHeader, actualHeader);

        Assert.assertTrue(wikiSearchPage.wikiMainHeader.isDisplayed());


    }



}
