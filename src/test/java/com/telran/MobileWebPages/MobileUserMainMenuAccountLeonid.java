package com.telran.MobileWebPages;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Leonid Gengrinovich
 */
public class MobileUserMainMenuAccountLeonid extends Page {

    @FindBy(xpath = "//div[@id='MainPage']//label[contains(text(), 'שאלון וונדרבילט למורה - דוח ממתין למילוי')]/../..//div[contains(text(), 'כעת')]")
    WebElement submitButton;

    @FindBy(xpath = ".//*[@id='listWaitingReports']/li")
    WebElement startButon;

    public MobileUserMainMenuAccountLeonid(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public MobileUserMainMenuAccountLeonid openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }


// wait
    public MobileUserMainMenuAccountLeonid waitUntilMenuPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(submitButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

// clicks
    public MobileUserMainMenuAccountLeonid clickOnSubmitButton() {
        clickElement(submitButton);
        return this;
    }

    public MobileUserMainMenuAccountLeonid waitUntilStartTestButtonIsLoaded() {
        try {
            waitUntilElementIsLoaded(startButon);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MobileUserMainMenuAccountLeonid clickOnStartTestButton() {
        clickElement(startButon);
        return this;
    }


    public boolean isOnLoginPage() {
        return exists(submitButton);
    }
}
