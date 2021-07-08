package test.example;

import model.pages.SelectListDemo;
import org.openqa.selenium.WebDriver;
import utils.Webdriver;

public class SelectListDemoTest {

    public static void main(String[] args) {

        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://www.seleniumeasy.com/test");
        driver.manage().window().maximize();

        SelectListDemo selectListDemo = new SelectListDemo(driver);
        selectListDemo.headerComponent().selectInputFormsOption(driver, "Select Dropdown List");

        // select 1 option in dropdown by value
        selectListDemo.selectByValue("Monday");

        // select 1 option in dropdown by index
        selectListDemo.selectByIndex(3);

        // select first option in multiple select list
        selectListDemo.selectFirstOptions();

        // select all option in multiple select list
        selectListDemo.selectAllOptions();

        driver.close();

    }
}
