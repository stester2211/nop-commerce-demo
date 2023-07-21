package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility
{
    //5.BuildYourOwnComputerPage - Build your own computer Text, Processor Drop Down, Ram drop down,
    //  HDD radios, os radio, software check boxes, Add To Card button, "The product has been added to your shopping cart"
    //  message locators and it's actions

    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement selectProcessor;
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement selectRam;
    @CacheLookup
    @FindBy(xpath = "//input[@name='product_attribute_3']")
    List<WebElement> selectHdd;
    @CacheLookup
    @FindBy(xpath = "//input[@name='product_attribute_4']")
    List<WebElement> selectOs;
    @CacheLookup
    @FindBy(xpath = "//input[@name='product_attribute_5']")
    List<WebElement> selectSoftware;
    @CacheLookup
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement clickAddToCart;
    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement actualTextProductAdded;

    public void selectProcessor(String chooseProcessor)
    {
        //Select processor "processor"
        selectByVisibleTextFromDropDown(selectProcessor,chooseProcessor);
    }
    public void selectRam(String chooseRam)
    {
        //Select RAM "ram"
        selectByVisibleTextFromDropDown(selectRam,chooseRam);
    }
    public void selectHdd(String hdd)
    {
        //Select HDD "hdd"
        for (WebElement hddElement : selectHdd) {
            if (hddElement.getText().contains(hdd)) {
                clickOnElement(hddElement);
                break;
            }
        }
    }
    public void selectOs(String os)
    {
        //Select OS "os"
        for (WebElement osElement : selectOs) {
            if (osElement.getText().contains(os)) {
                clickOnElement(osElement);
                break;
            }
        }
    }
    public void selectSoftware(String software)
    {
        //Select Software "software"
        for (WebElement softwareElement : selectSoftware) {
            if (softwareElement.getText().contains(software)) {
                clickOnElement(softwareElement);
                break;
            }
        }
    }
    public void clickOnAddToCartButton()
    {
        //Click on "ADD TO CART" Button
        clickOnElement(clickAddToCart);
    }
    public String verifyProductAddedToCart()
    {
        //Verify message "The product has been added to your shopping cart"
        return getTextFromElement(actualTextProductAdded).replace("x"," ");
    }
}
