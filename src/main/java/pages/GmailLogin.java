package pages;

import core.WebDriverWrapper;
import org.openqa.selenium.WebDriver;

/**
 * Created by a.verma on 3/8/17.
 */
public class GmailLogin {
    //Declare all the constant page object fields, WebDriver & WebDriverWrapper objects
    WebDriverWrapper driverWrapper = new WebDriverWrapper();
    final String userNameLocator="Email";
    final String userPwdLocator="Passwd";
    final String signInButton="signIn";
    final String nextButton="next";


    public void typeUserName(String text, WebDriver driver)
    {
        driverWrapper.type(text, userNameLocator, driver);
    }

    public void typeUserPwd(String text, WebDriver driver)
    {
        driverWrapper.type(text, userPwdLocator, driver);
    }

    public void clickNextButton(WebDriver driver)
    {
        driverWrapper.getWebElement(nextButton,driver).click();

    }
    public void  clickSignInButton(WebDriver driver)
    {
        driverWrapper.getWebElement(signInButton, driver).click();

    }





}
