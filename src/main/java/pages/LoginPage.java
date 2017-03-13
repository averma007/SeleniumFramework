package pages;
import core.Utility;
import core.WebDriverWrapper;
import org.openqa.selenium.WebDriver;

/**
 * Created by a.verma on 3/8/17.
 */

public class LoginPage {
    String userNameLocator="inputEmail";
    String userPwdLocator="inputPassword";
    String signInButton=".btn btn-lg btn-primary btn-block btn-signin";
    WebDriverWrapper driverWrapper = new WebDriverWrapper();

    public void typeUserName(String userName, WebDriver driver)
    {
        driverWrapper.type(userName, userNameLocator, driver);
    }
    public void typeUserPwd(String userPwd, WebDriver driver)
    {
        driverWrapper.type(userPwd, userPwdLocator, driver);
    }
    public void clickSignInButton(WebDriver driver)
    {
        driverWrapper.getWebElement(signInButton, driver).click();
    }


}
