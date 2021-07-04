package model.pages;

import model.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckboxDemo {

    private WebDriver webDriver;

    private By singleCheckbox = By.cssSelector("input#isAgeSelected");
    private By verifyCheckbox = By.cssSelector("div#txtAge");
    private Header headerComponet;


    public Header headerComponent() {
        return new Header(webDriver);
    }

    public CheckboxDemo(WebDriver driver) {
        this.webDriver = driver;
    }


    public void checkOnCheckbox(WebDriver driver) {
        driver.findElement(singleCheckbox).click();
    }

    public void verifyCheckbox(WebDriver driver, String expected) {
        String actualMessage = driver.findElement(verifyCheckbox).getText();
        Assert.assertEquals(actualMessage, expected);
    }
}
