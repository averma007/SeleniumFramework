package pages;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import core.*;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

/**
 * Created by a.verma on 3/13/17.
 */
public class LoginPageTest {
    WebDriverWrapper wrapper = new WebDriverWrapper();
    final String webpage = "http://192.168.70.43:3002/";
    LoginPage loginPageObj = new LoginPage();
    @BeforeMethod
    public void setUp() throws Exception {

        wrapper.setDriver("Mac", "Firefox");
    }
    @Test
    public void testLoginPage(){
        wrapper.goURL(webpage, wrapper.getDriver());
        wrapper.pageLoadWait();
        Assert.assertEquals("React Redux Starter Kit", wrapper.getDriver().getTitle());

        loginPageObj.typeUserName("liron@gmail.com", wrapper.getDriver());
        loginPageObj.typeUserPwd("123", wrapper.getDriver());
        loginPageObj.clickSignInButton(wrapper.getDriver());

        wrapper.pageLoadWait();
        Assert.assertEquals("", wrapper.getDriver().getCurrentUrl());
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Utility.getFailedResults(result, wrapper.getDriver());
        wrapper.getDriver().quit();

    }

}