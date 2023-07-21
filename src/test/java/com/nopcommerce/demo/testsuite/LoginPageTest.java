package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)

public class LoginPageTest extends BaseTest
{
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage= new HomePage();
        loginPage= new LoginPage();
    }

    SoftAssert softAssert= new SoftAssert();

    //1.userShouldNavigateToLoginPageSuccessFully().
    @Test
    public void userShouldNavigateToLoginPageSuccessFully()
    {
        //Click on login link
        homePage.clickOnLoginLink();

        //verify that "Welcome, Please Sign In!" message display
        softAssert.assertEquals(loginPage.verifyWelcomeMessage(),"Welcome, Please Sign In!","Welcome text not found");
        softAssert.assertAll();
    }

    //2. verifyTheErrorMessageWithInValidCredentials().
    @Test
    public void verifyTheErrorMessageWithInValidCredentials()
    {
        //Click on login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmail("vishwa@gmail.com");

        //Enter Password
        loginPage.enterPassword("v123456");

        //Click on Login Button
        loginPage.clickLoginButton();

        //Verify that the Error message
        softAssert.assertEquals(loginPage.verifyErrorMessageText(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found","Error message not found");
        softAssert.assertAll();
    }

    //3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
    @Test
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials()
    {
        //Click on login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmail("vishwa@gmail.com");

        //Enter Password
        loginPage.enterPassword("v123456");

        //Click on Login Button
        loginPage.clickLoginButton();

        //Verify that LogOut link is display
        softAssert.assertEquals(homePage.verifyLogoutLinkText(),"Log out","Logout link text is not displayed");
    }

    //4. VerifyThatUserShouldLogOutSuccessFully()
    @Test
    public void VerifyThatUserShouldLogOutSuccessFully()
    {
        //Click on login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmail("vishwa@gmail.com");

        //Enter Password
        loginPage.enterPassword("v123456");

        //Click on Login Button
        loginPage.clickLoginButton();

        //Click on LogOut Link
        homePage.clickOnLogoutLink();

        //Verify that LogIn Link Display
        softAssert.assertEquals(homePage.verifyLoginLinkText(),"Log in","Login link not displayed");
    }

}

