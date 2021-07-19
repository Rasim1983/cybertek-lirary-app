package com.cybertek.library.step_Definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url = ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        String username = ConfigurationReader.getProperty("librarian_username");
        String password = ConfigurationReader.getProperty("librarian_password");
        loginPage.inputUserName.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.signIn.click();

    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expected = "dashboard";

        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));
        //Driver.closeDriver();

    }


    @When("I login as a student")
    public void iLoginAsAStudent() {
        String username = ConfigurationReader.getProperty("student_username");
        String password = ConfigurationReader.getProperty("student_password");
        loginPage.inputUserName.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.signIn.click();

    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        String expected = "books";
        wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        // Driver.closeDriver();

    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.inputUserName.sendKeys(username);

    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.inputPassword.sendKeys(password);
    }


    @And("click the sign in button")
    public void clickTheSignInButton() {
        loginPage.signIn.click();

    }

    @And("there should be {int} users")
    public void thereShouldBeUsersNumbercanBeWhateverYouHaveThere(Integer expected) {
        int expectedUserName = expected;
        String expectedCount = String.valueOf(expectedUserName);
        String actualCount = landingPage.userCount.getText();
//        System.out.println("actualCount = " + actualCount);
//        System.out.println("expectedCount = " + expectedCount);

        Assert.assertEquals(actualCount, expectedCount);

    }


    @When("I login using {string}and {string}")
    public void iLoginUsingAnd(String username, String password) {
        loginPage.inputUserName.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.signIn.click();

    }

    @And("I click on {string}link")
    public void iClickOnLink(String arg0) {
        landingPage.usersLink.click();

    }


    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String expectedAccountUserName) {
        String actualAccountUserName = landingPage.accountUserName.getText();

        Assert.assertEquals(actualAccountUserName,expectedAccountUserName);


        Driver.closeDriver();

    }
}
