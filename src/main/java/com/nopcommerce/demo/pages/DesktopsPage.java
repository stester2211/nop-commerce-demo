package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopsPage extends Utility
{
    //4.DesktopsPage - Desktops text, Sortby, Display, selectProductList Locators and it's actions
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement actualTextDesktop;
    @CacheLookup
    //@FindBy(xpath = "//h2[@class='product-title']")
    @FindBy(xpath = "//div[@class='product-item']")
    List<WebElement> selectProduct;
    public String  verifyTextDesktop()
    {
        //Verify "Desktops" text
        return getTextFromElement(actualTextDesktop);
    }
    public void selectProductFromList(String product)
    {
        //Click on product name "Build your own computer"
        for (WebElement productElement : selectProduct) {
            if (productElement.getText().contains(product)) {
                clickOnElement(productElement);
                break;
            }
        }
    }

}
