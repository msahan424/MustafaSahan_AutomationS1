package com.mstf.step_definitions;

import com.mstf.pages.ExpiredPage;
import com.mstf.pages.HomePage;
import com.mstf.pages.LoginPage;
import com.mstf.utilities.ConfigurationReader;
import com.mstf.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogOutFunctionality_StepDefinitions {
    HomePage HomePage = new HomePage();
    LoginPage LoginPage = new LoginPage();

    com.mstf.pages.ExpiredPage ExpiredPage = new ExpiredPage();
    @Given("user is already logged in")
    public void user_is_already_logged_in() {
        Driver.getDriver().get("https://qa.fidexio.com/");
        LoginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("SalesManagerEmail"));
        LoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("SalesManagerPassword"));
        LoginPage.loginButton.click();

        Assert.assertTrue(LoginPage.userPage.isDisplayed());
    }
    @When("user clicks the logout button")
    public void user_clicks_the_logout_button() {
        HomePage.username.click();
        HomePage.logoutBtn.click();
    }
    @Then("user should land on the login page")
    public void user_should_land_on_the_login_page() {
        Assert.assertTrue(LoginPage.SignInBtn.isDisplayed());
    }
    @Given("user has logged out")
    public void userHasLoggedOut() {
        HomePage.username.click();
        HomePage.logoutBtn.click();
        Assert.assertTrue(LoginPage.SignInBtn.isDisplayed());
    }
    @When("user presses the backspace button after loggin out")
    public void userPressesTheBackspaceButtonAfterLogginOut() {
        Driver.getDriver().navigate().back();
    }
    @Then("user can not go to the homepage again")
    public void userCanNotGoToTheHomepageAgain() {

        Assert.assertTrue(ExpiredPage.ExpiredMsj.isDisplayed());

    }
}
