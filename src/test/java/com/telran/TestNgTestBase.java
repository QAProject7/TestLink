package com.telran;

import com.telran.util.PropertyLoader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  public static String baseUrl;
  protected static String gridHubUrl;
  protected static Capabilities capabilities;
  public WebDriver driver;

  @BeforeSuite(alwaysRun = true)
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");//загружает capabilities
    capabilities = PropertyLoader.loadCapabilities();
    // WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    //driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    driver = new FirefoxDriver();
  }

  public WebDriver getDriver() {
    return driver;
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    /*if (driver != null) {
      driver.quit();
    }*/
  }
}
