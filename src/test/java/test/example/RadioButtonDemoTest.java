package test.example;

import model.pages.CheckboxDemo;
import model.pages.RadioButtonDemo;
import org.openqa.selenium.WebDriver;
import utils.Webdriver;

public class RadioButtonDemoTest {

    public static void main(String[] args) {

        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://www.seleniumeasy.com/test");
        driver.manage().window().maximize();

        RadioButtonDemo radioButtonDemo = new RadioButtonDemo(driver);
        radioButtonDemo.headerComponent(driver).selectInputFormsOption(driver, "Radio Buttons Demo");

        // verify Radio button is Not checked
        radioButtonDemo.validateCheckValue();

        // verify Female option is checked
        radioButtonDemo.selectOption("female");
        radioButtonDemo.validateCheckValue();

        // verify Male option is checked
        radioButtonDemo.selectOption("male");
        radioButtonDemo.validateCheckValue();

        driver.close();

    }
}
