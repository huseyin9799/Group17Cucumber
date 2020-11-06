package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();

    @Given("{string} is on the login page")
    public void is_on_the_login_page(String string) {
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
    }

    @When("{string} enters username and password and clicks log in")
    public void enters_username_and_password_and_clicks_log_in(String role) {
        String username = "";

        if (role.equals("driver")){
            username = ConfigurationReader.getProperty("driver.username");
        }else if (role.equals("sales manager")){
            username = ConfigurationReader.getProperty("sales_manager.username");
        }else if (role.equals("store manager")){
            username = ConfigurationReader.getProperty("store_manager.username");
        }

        String password = ConfigurationReader.getProperty("vytrack.password");

        loginPage.login(username,password);
        BrowserUtils.wait(3);
    }

    @Then("{string} should be on Dashboard")
    public void should_be_on_dashboard(String string) {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals("Titles aren't matching!",actualTitle,expectedTitle);
    }
}
