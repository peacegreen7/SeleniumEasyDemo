package test.example;

import driver.DriverBase;
import model.pages.DynamicDataLoading;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Webdriver;

import static org.testng.Assert.fail;


public class DynamicDataLoadingTest extends DriverBase {

    @Test
    public void TC_O1 () {
//    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
        driver.manage().window().maximize();

        DynamicDataLoading dynamicDataLoading = new DynamicDataLoading(driver);
        dynamicDataLoading.clickOnAddNewBtn();
        if (!dynamicDataLoading.checkUser()) {
            fail();
        }

    }

}
