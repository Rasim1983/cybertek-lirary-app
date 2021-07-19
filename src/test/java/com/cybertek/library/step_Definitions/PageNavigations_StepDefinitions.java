package com.cybertek.library.step_Definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.ListUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageNavigations_StepDefinitions {

    LandingPage landingPage = new LandingPage();
    UsersPage usersPage = new UsersPage();
    Select select;

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {
        select = new Select(usersPage.showRecDropdown);
        Integer actual = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println(actual);
        Assert.assertEquals(actual, expected);


    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> expected) {
        select = new Select(usersPage.showRecDropdown);
        List<WebElement> optionWebElements = select.getOptions();
        List<String> actual = ListUtils.getTextOfElement(optionWebElements);
        Assert.assertEquals(actual,expected);

    }
}
