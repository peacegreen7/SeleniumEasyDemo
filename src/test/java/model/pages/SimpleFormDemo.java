package model.pages;

import model.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SimpleFormDemo {

    private WebDriver webDriver;
    private By messageSelector = By.cssSelector("input#user-message");
    private By showMessageBtnSelector = By.cssSelector("//button[contains(text(), 'Show Message')]");
    private By verifyMessageSelector = By.cssSelector("div#user-message span");
    private By number1Selector = By.cssSelector("input#sum1");
    private By number2Selector = By.cssSelector("input#sum2");
    private By getTotalBtnSelector = By.cssSelector("//button[contains(text(), 'Get Total')]");
    private By verifyTotalSelector = By.cssSelector("span#displayvalue");
    private Header headerComponet;


    public Header headerComponent() {
        return new Header(webDriver);
    }

    public SimpleFormDemo(WebDriver driver) {
        this.webDriver = driver;
    }

    public void enterUsername(WebDriver driver, String message) {
        driver.findElement(messageSelector).sendKeys(message);
    }

    public void clickOnShowBtn(WebDriver driver) {
        driver.findElement(showMessageBtnSelector).click();
    }

    public void verifyMessage(WebDriver driver, String expectedMessage) {
        String actualMessage = driver.findElement(verifyMessageSelector).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void enterNumber(WebDriver driver, int number1, int number2) {
        driver.findElement(number1Selector).sendKeys("" + number1);
        driver.findElement(number2Selector).sendKeys("" + number2);
    }

    public void clickOnTotalBtn(WebDriver driver) {
        driver.findElement(getTotalBtnSelector).click();
    }

    public void verifyTotalNumber(WebDriver driver, String expectedTotal) {
        String actualMessage = driver.findElement(verifyTotalSelector).getText();
        Assert.assertEquals(actualMessage, expectedTotal);
    }
}
