package test.example;

import model.pages.CheckboxDemo;
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

        //verify page title
        String actual = checkboxDemo.headerComponent().getVerifyContentPage(driver);
        Assert.assertEquals(actual, "This would be a basic example to start with checkboxes using selenium.");

        /* ================================= Single checkbox section =======================================*/
        //checked on single checkbox
        checkboxDemo.checkOnCheckbox();
        checkboxDemo.verifyCheckbox("Success - Check box is checked");
        //unchecked on single checkbox
        checkboxDemo.checkOnCheckbox();
        if (!checkboxDemo.getCheckboxElement().isSelected()) {
            System.out.println("Uncheck single checkbox successfully");
        }

        /* ================================= Multiple checkbox section =======================================*/
        //check one option in list option
        checkboxDemo.getMultipleOption(2).click();
        Assert.assertEquals(checkboxDemo.getCheckBtnText(), "Check All");
        //select all options
        checkboxDemo.toggleAllOption();
        Assert.assertEquals(checkboxDemo.getCheckBtnText(), "Uncheck All");
        //unselect all options
        checkboxDemo.toggleAllOption();
        Assert.assertEquals(checkboxDemo.getCheckBtnText(), "Check All");

        //close browser
        driver.close();

    }

}
