package test.example;

import model.pages.SimpleFormDemo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Webdriver;


public class SimpleFormDemoTest {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://www.seleniumeasy.com/test");
        driver.manage().window().maximize();

        SimpleFormDemo simpleFormDemo = new SimpleFormDemo(driver);

        simpleFormDemo.headerComponent().selectInputFormsOption(driver, "Simple Form Demo");
        String actual = simpleFormDemo.headerComponent().getVerifyContentPage(driver);

        Assert.assertEquals(actual, "This would be your first example to start with Selenium.");

        // Single Input Field
        String message = "Hello World";
        simpleFormDemo.enterUsername(driver, message);


        simpleFormDemo.clickOnShowBtn(driver);
        simpleFormDemo.verifyMessage(driver, message);

        // Two Input Field

    }

}
