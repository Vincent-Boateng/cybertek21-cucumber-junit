package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownsPage {

    WebDriver driver = Driver.getDriver();
    public DropdownsPage(){


        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "month")
   public WebElement monthDropdown;


}
