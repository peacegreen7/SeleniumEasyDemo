package test.parallel;

import driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDriverInstances extends DriverBase {

    @Test
    @Parameters({"browser"})
    public void testLoginCrossBrowser(String browser) {
        WebDriver driver = getDriver(browser);
        driver.get("http://the-internet.herokuapp.com/login");

    }


}
