package com.mstf.step_definitions;

import com.mstf.pages.LoginPage;
import com.mstf.utilities.BrowserUtils;
import com.mstf.utilities.ConfigurationReader;
import com.mstf.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


import java.util.concurrent.TimeUnit;

public class LoginFunctionality_FirstStepDefinitions {
   LoginPage LoginPage = new LoginPage();
    @Given("Fidexio webpage is open")
    public void fidexio_webpage_is_open() {
        Driver.getDriver().get("https://qa.fidexio.com/");
    }
    @When("user enters valid email{string}And password {string}")
    public void userEntersValidEmailAndPassword(String username, String password) {
        LoginPage.inputUsername.sendKeys(username);
        LoginPage.inputPassword.sendKeys(password);
    }


    @When("user should able to login")
    public void user_should_able_to_login() {
        LoginPage.loginButton.click();
    }

    @Then("user should see login page title")
    public void user_should_see_login_page_title() {
     String actualTitle ="Odoo";
     String expectedTitle = Driver.getDriver().getTitle();

     Assert.assertEquals(actualTitle,expectedTitle);
     if (actualTitle==expectedTitle){
      System.out.println("you are in the login page");
     }

    }


 @When("user enters valid or invalid {string}")
 public void userEntersValidOrInvalid(String username) {
  LoginPage.inputUsername.sendKeys(username);
 }

 @And("user enters invalid or valid {string}")
 public void userEntersInvalidOrValid(String password) {
  LoginPage.inputPassword.sendKeys(password);
 }

 @Then("Wrong login or password should be displayed")
 public void wrongLoginOrPasswordShouldBeDisplayed() {
  LoginPage.loginButton.click();

  Assert.assertTrue(LoginPage.wrongLogin.isDisplayed());

 }

    @When("user enters only {string}")
    public void userEntersOnly(String username) {
        LoginPage.inputUsername.sendKeys(username);
        LoginPage.loginButton.click();
    }





    @Then("user should see warning message {string}")
    public void userShouldSeeWarningMessage() {


        Driver.getDriver().manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        if (LoginPage.inputPassword.getAttribute("required").equals("required")) {
            Assert.assertEquals(LoginPage.inputPassword.getAttribute("validationMessage"), "Please fill out this field.");
        }



    }
    @When("or {string}")
    public void or(String password) {
        LoginPage.inputPassword.sendKeys(password);
        LoginPage.loginButton.click();
    }
    @Then("user should see again warning message {string}")
    public void userShouldSeeAgainWarningMessage(String arg0) {
        if (LoginPage.inputUsername.getAttribute("required").equals("required")) {
            Assert.assertEquals(LoginPage.inputUsername.getAttribute("validationMessage"), "Please fill out this field.");
        }
    }
   /*
        String actualTitle2 = "Please fill in this field.";
        String expectedTitle2 = LoginPage.inputUsername.getAttribute("validationMessage");
        Assert.assertEquals(actualTitle2, expectedTitle2);
        if (LoginPage.inputUsername.getAttribute("value").isEmpty()) {
            if (actualTitle2.equals(expectedTitle2)) {
                Assert.assertTrue(LoginPage.inputUsername.isDisplayed());

                System.out.println("Test Passed");
            } else {
                System.out.println("test Failed");
            }
        }
    }
*/
    @When("user enters valid password")
    public void userEntersValid( ) {

        LoginPage.inputPassword.sendKeys("password");
    }

    @Then("User should see the password in bullet signs by default")
    public void userShouldSeeThePasswordInBulletSignsByDefault() {
        Assert.assertEquals("password",LoginPage.inputPassword.getAttribute("type"));
    }
    @When("user enters email and password")
    public void user_enters_email_and_password() {
        LoginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("SalesManagerEmail"));
        LoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("SalesManagerPassword"));
    }
    @Then("user should be able to login in using the Enter key")
    public void user_should_be_able_to_login_in_using_the_enter_key() {
        LoginPage.inputUsername.sendKeys(Keys.ENTER);
        Assert.assertTrue(LoginPage.userPage.isDisplayed());
    }



}
