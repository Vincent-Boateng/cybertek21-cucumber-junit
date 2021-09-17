package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {

    public WikiSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement wikiSearchBox;

    @FindBy(xpath = "//i[@class='sprite svg-search-icon']")
    public WebElement wikiSearchButton;

    @FindBy(id = "firstHeading")
    public WebElement wikiMainHeader;


}
