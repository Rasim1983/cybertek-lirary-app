package com.cybertek.library.step_Definitions;

import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.ListUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersTable_StepDefinitions {
    UsersPage usersPage = new UsersPage();
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
        List<String> actualColumnNames = ListUtils.getTextOfElement(usersPage.tableHeaders);
       // System.out.println(actualColumnNames);
        Assert.assertEquals(actualColumnNames,expectedColumnNames);


    }
}
