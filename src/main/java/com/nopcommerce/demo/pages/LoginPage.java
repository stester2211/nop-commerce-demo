package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility
{
    //1.LoginPage - Email, password, Login Button and "Welcome, Please Sign In!" text Locators
    //  and create appropriate methods for it.
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement actualWelcomeText;
    @CacheLookup
    @FindBy(xpath = "//input[@id='Email']")
    WebElement enterEmail;
    @CacheLookup
    @FindBy(xpath = "//input[@id='Password']")
    WebElement enterPassword;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement clickLoginBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement actualErrorMessage;
    public String verifyWelcomeMessage()
    {
        //verify that "Welcome, Please Sign In!" message display
        return getTextFromElement(actualWelcomeText);
    }
    public void enterEmail(String email)
    {
        //Enter EmailId
        sendTextToElement(enterEmail,email);
    }
    public void enterPassword(String password)
    {
        //Enter Password
        sendTextToElement(enterPassword,password);
    }
    public void clickLoginButton()
    {
        //Click on Login Button
        clickOnElement(clickLoginBtn);
    }
    public String verifyErrorMessageText()
    {
        //Verify that the Error message
        return getTextFromElement(actualErrorMessage);
    }


}
