package test.example;

import model.pages.CheckboxDemo;
import model.pages.SimpleFormDemo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Webdriver;


public class CheckboxDemoTest {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://www.seleniumeasy.com/test");
        driver.manage().window().maximize();

        CheckboxDemo checkboxDemo = new CheckboxDemo(driver);

        checkboxDemo.headerComponent().selectInputFormsOption(driver, "Checkbox Demo");
//        String actual = checkboxDemo.headerComponent().getVerifyContentPage(driver);

//        Assert.assertEquals(actual, "This would be your first example to start with Selenium.");

       checkboxDemo.checkOnCheckbox(driver);
       checkboxDemo.verifyCheckbox(driver, "Success - Check box is checked");

        // Two Input Field

    }

}
