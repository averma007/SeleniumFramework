package core;

/**
 * Created by a.verma on 3/8/17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// Wrapper class for encapsulating all methods pertaining to webelement and WebDriver.
public class WebDriverWrapper {
    protected WebDriver _driver;

//    Set the driver based on OS & browser.
    public WebDriver setDriver(String os, String browser) {
        System.setProperty("webdriver.gecko.driver", "/Users/a.verma/Downloads/geckodriver");
        this._driver = new FirefoxDriver();
        this._driver.manage().window().maximize();

//        WebDriver driver = null;
//        if (os.equalsIgnoreCase("Windows")) {
//            switch (browser) {
//                case ("Firefox"):
//
//                case ("Chrome"):
//
//                case ("Edge"):
//
//                case ("IE"):
//            }
//
//        }
//
//        if (os.equalsIgnoreCase("Mac"))
//        {
//            switch (browser){
//                case ("Firefox"):
//                {
//                    System.setProperty("webdriver.gecko.driver", "/Users/a.verma/Downloads/geckodriver");
//                     WebDriver driver = new FirefoxDriver();
//                }
//                case("Chrome"):
//                    {}
//                case("Safari"):
//                {}
//            }
//        }
        return _driver;
    }

//    Use this to access WebDriver. Layer of encapsulation, so nothing goofy happens!
    public WebDriver getDriver()
    {
        return this._driver;
    }

//    Only use if no other way out
    public void pageLoadWait()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goURL(String url, WebDriver driver){
        driver.manage().window().maximize();
        driver.get(url);
    }

//    Do any actions on an WebElement after it's visible
    public void isWebElementVisible(WebElement element, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(_driver,5 );
        wait.until(ExpectedConditions.visibilityOf(element));
    }

//    Get the WebElemnt as xpath, css, id. Will expand as needed
    public WebElement getWebElement(String locator, WebDriver driver)
    {
        String char_start = Character.toString(locator.charAt(0));
        WebElement element;
        if (char_start.equalsIgnoreCase("."))
        {
            element = driver.findElement(By.cssSelector(locator));
            if( !(element.isDisplayed())) {
                isWebElementVisible(element, driver);
            }


        }
        else if(char_start.equalsIgnoreCase("/"))
        {
            element = driver.findElement(By.xpath(locator));
        }
        else
        {
            element = driver.findElement(By.id(locator));
        }
        return element;
    }

    public void type(String text, String locator, WebDriver driver)
    {
        getWebElement(locator,driver).clear();
        getWebElement(locator, driver).click();
        getWebElement(locator, driver).sendKeys(text);
    }

    public static void rightClick(WebDriver driver, WebElement elem){
        Action action = new Actions(driver).contextClick(elem).build();
        action.perform();
    }

    public static void doubleClick(WebDriver driver, WebElement elem)
    {
        Actions action = new Actions(driver);
        action.doubleClick(elem).perform();
    }


}

