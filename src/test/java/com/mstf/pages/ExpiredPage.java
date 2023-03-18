package com.mstf.pages;

import com.mstf.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpiredPage {
    public ExpiredPage () { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//div[@class='o_dialog_warning modal-body']")
    public WebElement ExpiredMsj;
}
