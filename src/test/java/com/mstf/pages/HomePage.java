package com.mstf.pages;

import com.mstf.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement username;

    @FindBy (xpath = "//a[@data-menu='logout']")
    public WebElement logoutBtn;



}

