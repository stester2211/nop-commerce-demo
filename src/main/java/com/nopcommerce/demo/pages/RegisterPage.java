package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterPage extends Utility
{
    //6.RegisterPage - Register Text, male female radio, Firstname, lastname, Date of Birth drop downs, email,
    //  Password, Confirm Password, Register Button, "First name is required.","Last name is required.",
    //  "Email is required.","Password is required.", "Password is required." error message,
    //  "Your registration completed" message, "CONTINUE" button
    //  Locators and it's actions

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement actualTextRegister;
    @CacheLookup
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement clickRegisterButton;
    @CacheLookup
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement actualFirstNameText;
    @CacheLookup
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement actualLastNameText;
    @CacheLookup
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement actualEmailText;
    @CacheLookup
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement actualPasswordText;
    @CacheLookup
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement actualConfirmPasswordText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='gender']")
    List<WebElement> selectGender;
    @CacheLookup
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement enterFirstName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement enterLastName;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement selectDay;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement selectMonth;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement selectYear;
    @CacheLookup
    @FindBy(xpath = "//input[@id='Email']")
    WebElement enterEmail;
    @CacheLookup
    @FindBy(xpath = "//input[@id='Password']")
    WebElement enterPassword;
    @CacheLookup
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement enterConfirmPassword;
    @CacheLookup
    @FindBy(xpath = "//div[@class='result']")
    WebElement verifyRegisterCompleteText;

    public String verifyTextRegister()
    {
        //Verify "Register" text
        return getTextFromElement(actualTextRegister);
    }
    public void clickOnRegisterButton()
    {
        //Click on "REGISTER" button
        clickOnElement(clickRegisterButton);
    }
    public String verifyTextFirstName()
    {
        //Verify the error message "First name is required."
        return getTextFromElement(actualFirstNameText);
    }
    public String verifyTextLastName()
    {
        //Verify the error message "Last name is required."
       return getTextFromElement(actualLastNameText);
    }
    public String verifyTextEmail()
    {
        //Verify the error message "Email is required."
        return getTextFromElement(actualEmailText);
    }
    public String verifyTextPassword()
    {
        //Verify the error message "Password is required."
        return getTextFromElement(actualPasswordText);
    }
    public String verifyTextConfirmPassword()
    {
        //Verify the error message "Password is required."
        return getTextFromElement(actualConfirmPasswordText);
    }
    public void selectGender(String gender)
    {
        //Select gender "Female"
        for (WebElement genderElement : selectGender) {
            if (genderElement.getText().contains(gender)) {
                clickOnElement(genderElement);
                break;
            }
        }
    }
    public void enterFirstName(String fName)
    {
        //Enter firstname
        sendTextToElement(enterFirstName,fName);
    }
    public void enterLastName(String lName)
    {
        //Enter lastname
        sendTextToElement(enterLastName,lName);
    }
    public void selectDay(String day)
    {
        //Select day
        selectByVisibleTextFromDropDown(selectDay,day);
    }
    public void selectMonth(String month)
    {
        //Select month
        selectByVisibleTextFromDropDown(selectMonth,month);
    }
    public void selectYear(String year)
    {
        //Select year
        selectByVisibleTextFromDropDown(selectYear,year);
    }
    public void enterEmail(String email)
    {
        //Enter email
        sendTextToElement(enterEmail,email);
    }
    public void enterPassword(String password)
    {
        //Enter password
        sendTextToElement(enterPassword,password);
    }
    public void enterConfirmPassword(String confirmPassword)
    {
        //Enter Confirm Password
        sendTextToElement(enterConfirmPassword,confirmPassword);
    }
    public String verifyRegisterTextCompleted()
    {
        //Verify "Register" text
        return getTextFromElement(verifyRegisterCompleteText);
    }

}
