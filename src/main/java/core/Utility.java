package core;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Utility
{
    public static void captureScreenshot(WebDriver driver,String screenshotName)
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdf.format(date);

        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            File source=ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".jpeg"+formattedDate));

            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }

    public static void getFailedResults(ITestResult result, WebDriver driver)
    {
        if(ITestResult.FAILURE ==result.getStatus())
        {
            Utility.captureScreenshot(driver,"Failure Screenshot");
        }
    }
}