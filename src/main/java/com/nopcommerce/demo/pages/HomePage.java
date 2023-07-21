package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility
{
    //2.HomePage - All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My account link and LogOut link locatores
    //  and create appropriate methods for it.
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement actualLogoutLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement clickLogoutBtn;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement actualTextLoginLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement clickRegisterLink;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement clickOnComputerTab;
    public void clickOnLoginLink()
    {
        //Click on login link
        clickOnElement(loginLink);
    }
    public String verifyLogoutLinkText()
    {
        //Verify that LogOut link is display
        return getTextFromElement(actualLogoutLink);
    }
    public void clickOnLogoutLink()
    {
        //Click on LogOut Link
        clickOnElement(clickLogoutBtn);
    }
    public String verifyLoginLinkText()
    {
        //Verify that LogIn Link Display
        return getTextFromElement(actualTextLoginLink);
    }
    public void clickOnRegisterLink()
    {
        //Click on Register Link
        clickOnElement(clickRegisterLink);
    }
    public void clickOnComputerTab()
    {
        //Click on Computer tab
        clickOnElement(clickOnComputerTab);
    }
}
