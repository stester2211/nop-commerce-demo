package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testdata.TestData;

@Listeners(CustomListeners.class)

public class ComputerPageTest extends BaseTest
{
    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage= new HomePage();
        computerPage= new ComputerPage();
        desktopsPage= new DesktopsPage();
        buildYourOwnComputerPage= new BuildYourOwnComputerPage();
    }
    SoftAssert softAssert= new SoftAssert();

    //1. verifyUserShouldNavigateToComputerPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToComputerPageSuccessfully()
    {
        //Click on Computer tab
        homePage.clickOnComputerTab();

        //Verify "Computer" text
        softAssert.assertEquals(computerPage.verifyTextComputer(),"Computers","Computer text not found");
        softAssert.assertAll();
    }

    //2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully()
    {
        //Click on Computer tab
        homePage.clickOnComputerTab();

        //Click on Desktops link
        computerPage.clickOnDesktopLink();

        //Verify "Desktops" text
        softAssert.assertEquals(desktopsPage.verifyTextDesktop(),"Desktops","Desktop text not found");
        softAssert.assertAll();
    }

    //3. VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully
    @Test(dataProvider = "buildProduct", dataProviderClass = TestData.class)
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor,String hdd, String ram, String os, String software) throws InterruptedException {
        //Click on Computer tab
        homePage.clickOnComputerTab();

        //Click on Desktops link
        computerPage.clickOnDesktopLink();

        //Click on product name "Build your own computer"
        desktopsPage.selectProductFromList("Build your own computer");

        //Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);
        Thread.sleep(1000);

        //Select RAM "ram"
        buildYourOwnComputerPage.selectRam(ram);
        Thread.sleep(1000);

        //Select HDD "hdd"
        buildYourOwnComputerPage.selectHdd(hdd);
        Thread.sleep(1000);

        //Select OS "os"
        buildYourOwnComputerPage.selectOs(os);
        Thread.sleep(1000);

        //Select Software "software"
        buildYourOwnComputerPage.selectSoftware(software);
        Thread.sleep(1000);

        //Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartButton();

        //Verify message "The product has been added to your shopping cart"
        softAssert.assertEquals(buildYourOwnComputerPage.verifyProductAddedToCart(),"The product has been added to your shopping cart","Product not added to cart");
        softAssert.assertAll();
        Thread.sleep(1000);
    }

}
