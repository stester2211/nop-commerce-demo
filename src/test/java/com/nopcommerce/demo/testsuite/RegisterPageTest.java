package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)

public class RegisterPageTest extends BaseTest
{
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage= new HomePage();
        registerPage= new RegisterPage();
    }

    SoftAssert softAssert= new SoftAssert();

    //1. verifyUserShouldNavigateToRegisterPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully()
    {
        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Verify "Register" text
        softAssert.assertEquals(registerPage.verifyTextRegister(),"Register","Register page not displayed");
        softAssert.assertAll();
    }

    //2. verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
    @Test
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
    {
        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify the error message "First name is required."
        softAssert.assertEquals(registerPage.verifyTextFirstName(),"First name is required.","First name text not found");

        //Verify the error message "Last name is required."
        softAssert.assertEquals(registerPage.verifyTextLastName(),"Last name is required.","Last name required message not found");

        //Verify the error message "Email is required."
        softAssert.assertEquals(registerPage.verifyTextEmail(),"Email is required.","Email required message not display");

        //Verify the error message "Password is required."
        softAssert.assertEquals(registerPage.verifyTextPassword(),"Password is required.","Password required message not found");

        //Verify the error message "Password is required."
        softAssert.assertEquals(registerPage.verifyTextConfirmPassword(),"Password is required.","Confirm Password required message not found");
        softAssert.assertAll();
    }

    //3. VerifyThatUserShouldCreateAccountSuccessfully()
    @Test
    public void VerifyThatUserShouldCreateAccountSuccessfully()
    {
        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Select gender "Female"
        registerPage.selectGender("Female");

        //Enter firstname
        registerPage.enterFirstName("Vishwa");

        //Enter lastname
        registerPage.enterLastName("Patel");

        //Select day
        registerPage.selectDay("11");

        //Select month
        registerPage.selectMonth("July");

        //Select year
        registerPage.selectYear("1996");

        //Enter email
        registerPage.enterEmail("vishwapatel@gmail.com");

        //Enter password
        registerPage.enterPassword("v123456");

        //Enter Confirm Password
        registerPage.enterConfirmPassword("v123456");

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify message "Your registration completed"
        softAssert.assertEquals(registerPage.verifyRegisterTextCompleted(),"Your registration completed","Your registration is not completed");
        softAssert.assertAll();
    }
}
