package driver;

import org.openqa.selenium.WebDriver;
import utils.Webdriver;

public class DriverFactory {

    private WebDriver webDriver;

    public WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = Webdriver.getChromeDriver();
        }
        return webDriver;
    }

    public WebDriver getDriver(String browserName) {
        if (webDriver == null) {
            webDriver = Webdriver.getDriver(browserName);
        }
        return webDriver;
    }

    void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
