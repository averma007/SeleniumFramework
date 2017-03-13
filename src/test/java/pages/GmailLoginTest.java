package pages;

import core.Utility;
import core.WebDriverWrapper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;

/**
 * Created by a.verma on 3/8/17.
 */
public class GmailLoginTest {
//    Objects that will be used throughout the test
    WebDriverWrapper wrapper = new WebDriverWrapper();
    final String webpage = "http://www.gmail.com";
    GmailLogin gmailLogObj = new GmailLogin();

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
       wrapper.setDriver("Mac", "Firefox");

    }
//Adding parametrization for user-pwd combinations through Data Provider, and passing those params in the testMethod to run  *userName & userPwd
    @org.testng.annotations.Test (dataProvider = "testLogin")
    public void testGmailLogin(String userName, String userPwd){
        wrapper.goURL(webpage, wrapper.getDriver());
        wrapper.pageLoadWait();
        Assert.assertEquals("Gmail", wrapper.getDriver().getTitle());

        gmailLogObj.typeUserName(userName, wrapper.getDriver());
        gmailLogObj.clickNextButton(wrapper.getDriver());
        wrapper.pageLoadWait();

        gmailLogObj.typeUserPwd(userPwd, wrapper.getDriver());
        gmailLogObj.clickSignInButton(wrapper.getDriver());
        wrapper.pageLoadWait();
        Assert.assertTrue(wrapper.getDriver().getCurrentUrl().contains("inbox"));
    }

    @org.testng.annotations.AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        wrapper.getDriver().quit();
    }

//  All different user-pwd combinations to send through test
    @DataProvider(name="testLogin")
    public static Object [][] loginCombo(){
        Object [][] combination = new Object[2][2];
        combination[0][0]= "dailymtester1";    //Usr0
        combination[0][1]="dailymotiontester1";      //Usr0's Pwd
        combination[1][0]= "daily2tester";
        combination[1][1]="DAILYMOTION2TESTER!";
        return combination;
    }

}
