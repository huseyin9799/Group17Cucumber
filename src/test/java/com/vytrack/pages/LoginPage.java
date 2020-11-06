package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "prependedInput")
    private WebElement usernameInputBox;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInputBox;

    @FindBy(id = "_submit")
    private WebElement loginButton;

    public void login(String username, String password){
        BrowserUtils.enterText(usernameInputBox,username);
        BrowserUtils.enterText(passwordInputBox,password);
        BrowserUtils.clickOnElement(loginButton);
    }


}
