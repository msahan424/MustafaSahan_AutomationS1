package com.mstf.pages;

import com.mstf.utilities.ConfigurationReader;
import com.mstf.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;



    @FindBy(xpath = "//p[normalize-space(.)='Wrong login/password']")
    public WebElement wrongLogin;

    @FindBy (xpath = "//b[.='Sign in']")
    public WebElement SignInBtn;
    @FindBy(xpath = "//div[.='Congratulations, your inbox is empty']")
    public WebElement userPage;




}