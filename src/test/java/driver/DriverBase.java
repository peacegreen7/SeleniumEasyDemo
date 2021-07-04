/*
   Isolate Webdriver Instances in parallel test
 */

package driver;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DriverBase {

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverThread;


    @BeforeSuite(alwaysRun = true)
    public static void initWebdriverObject() {
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webdriverThread = new DriverFactory();
            webDriverThreadPool.add(webdriverThread);
            return webdriverThread;
        });
    }

    public static WebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    public static WebDriver getDriver(String browserName) {
        return driverThread.get().getDriver(browserName);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        for (DriverFactory driver: webDriverThreadPool) {
            driver.quitDriver();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        getDriver().manage().deleteAllCookies();

        if (result.getStatus() == ITestResult.FAILURE) {
            // 1. get the test method name
            String testMethodName = result.getName();
            // 2. Declare file location to screenshot
            Calendar calendar = new GregorianCalendar();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DATE);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);

            String takentime = year + "-" + month + "-" + day + "-" + hour + "-" + min + "-" + second;

            String location = System.getProperty("user.dir") + "/screenshot/" + testMethodName + takentime + ".png";
            // 3. Save the screenshot to system
            File screenShot = ((TakesScreenshot) driverThread.get().getDriver()).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenShot, new File(location));
                Path content = Paths.get(location);
                try (InputStream is =  Files.newInputStream(content)){
                    Allure.addAttachment(testMethodName, is);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}

