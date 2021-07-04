package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Webdriver {

    public static WebDriver getChromeDriver() {

        WebDriver driver;

        String path = System.getProperty("user.dir");

        String driverPath = path + "//selenium-grid" + "//chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();

//        RemoteWebDriver remoteWebDriver;
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setPlatform(Platform.ANY);
//        desiredCapabilities.setBrowserName("chrome");
//
//        try {
//            remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
//        } catch (Exception e) {
//            throw new RuntimeException(e.toString());
//        }
//
//        return remoteWebDriver;

    }

    public static WebDriver getDriver(String browserName) {

        RemoteWebDriver remoteWebDriver;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANY);

        if (browserName.equalsIgnoreCase("chrome")) {
            desiredCapabilities.setBrowserName("chrome");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            desiredCapabilities.setBrowserName("firefox");
        } else
            desiredCapabilities.setBrowserName("safari");

        try {
            remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }

        return remoteWebDriver;

    }
}
