package test.example;

import model.pages.AjaxFormSubmit;
import model.pages.CheckboxDemo;
import org.openqa.selenium.WebDriver;
import utils.Webdriver;

public class AjaxFormSubmitTest {

    public static void main(String[] args) {

        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://www.seleniumeasy.com/test");
        driver.manage().window().maximize();

        AjaxFormSubmit ajaxFormSubmit = new AjaxFormSubmit(driver);
        ajaxFormSubmit.headerComponent().selectInputFormsOption(driver, "Ajax Form Submit");

        ajaxFormSubmit.enterName("Hello this is name");
        ajaxFormSubmit.enterComment("Hello this is comment");
        ajaxFormSubmit.clickOnSubmitBtn();
//        ajaxFormSubmit.verifyMessage("Ajax Request is Processing!");
        ajaxFormSubmit.verifyMessage("Form submited Successfully!");

        driver.close();
    }
}
