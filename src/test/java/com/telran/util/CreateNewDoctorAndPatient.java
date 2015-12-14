package com.telran.util;

import com.telran.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class CreateNewDoctorAndPatient extends Page {


    //private WebDriver driver;
    private static final String TZ1 = "208463992";
    private static final String TZ2 = "385949870";
    LoginPage loginPage;
    RegistrationPage doctorRegistrationPage;
    DoctorsPage doctorsPage;
    CreateNewPatientPage createNewPatientPage;
    ChangePassRegistrationPatientOlgaPage fillprofilePage;
    //private String registered_doctor_name = "5998Doctor";
    private String registered_doctor_name = "493Doctor";
    private String registered_doctor_pass = "LinkCare!!11";
    private String email = "metupelet15@yopmail.com";

    public CreateNewDoctorAndPatient(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @BeforeClass(alwaysRun = true)
    public void PagesSetUp() throws Exception {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        doctorRegistrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);
        fillprofilePage = PageFactory.initElements(driver, ChangePassRegistrationPatientOlgaPage.class);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public String GenerateDoctorId() {
        String zeut = doctorRegistrationPage.generateZeut();
        return zeut;
    }

    public String GenerateDoctorUsername() {
        String username = doctorRegistrationPage.generateDoctorUsername();
        return username;
    }

    public String GeneratePatientId() {

        String pzeut = createNewPatientPage.generateZeut();
        return pzeut;
    }

    public String GeneratePatientParentEmail() {
        String ppemail = createNewPatientPage.generateParentEmail();
        return ppemail;
    }

    public String GeneratePatientteacherEmail() {
        String ppemail = createNewPatientPage.generateTeacherEmail();
        return ppemail;
    }

}