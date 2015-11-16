package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileForTeachersQuestionnairePageVadym extends Page{
    public MobileForTeachersQuestionnairePageVadym(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='MainPage']//label[contains(text(), 'שאלון וונדרבילט למורה - דוח ממתין למילוי')]/../..//div[contains(text(), 'כעת')]")
    WebElement submitButton;
}
