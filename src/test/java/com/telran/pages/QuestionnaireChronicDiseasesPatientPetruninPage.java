package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Petrunin on 30.11.2015.
 */
public class QuestionnaireChronicDiseasesPatientPetruninPage extends Page{

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;


    public QuestionnaireChronicDiseasesPatientPetruninPage(WebDriver driver) {
        super(driver);
    }
}
