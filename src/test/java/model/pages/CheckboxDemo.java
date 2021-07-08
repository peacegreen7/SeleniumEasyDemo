package model.pages;

import model.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckboxDemo {

    private WebDriver webDriver;

    private By singleCheckbox = By.cssSelector("input#isAgeSelected");
    private By verifyCheckbox = By.cssSelector("div#txtAge");
    private By checkBtnSelector = By.id("check1");
    private By optionSelector = By.cssSelector("input.cb1-element");
//    private By optionSelector = By.xpath("//input[@id='check1']/preceding-sibling::div[@class='checkbox']/descendant::input");

    public Header headerComponent() {
        return new Header(webDriver);
    }

    public CheckboxDemo(WebDriver driver) {
        this.webDriver = driver;
    }


    public WebElement getCheckboxElement() {
        return this.webDriver.findElement(singleCheckbox);
    }

    public WebElement getVerifyTextElement() {
        return this.webDriver.findElement(verifyCheckbox);
    }

    public void checkOnCheckbox() {
        this.getCheckboxElement().click();
    }

    public void verifyCheckbox(String expected) {
        String actualMessage = this.getVerifyTextElement().getText();
        if (this.getCheckboxElement().isSelected()) {
            Assert.assertEquals(actualMessage, expected);
            System.out.println("Checked on single checkbox successfully.");
        } else {
            Assert.fail();
        }
    }

    public WebElement getMultipleOption(int number) {
        return this.webDriver.findElements(optionSelector).get(number);
    }

    public void toggleAllOption() {
        this.getCheckBtn().click();
    }

    public WebElement getCheckBtn() {
        return this.webDriver.findElement(checkBtnSelector);
    }

    public String getCheckBtnText() {
        return this.getCheckBtn().getAttribute("value");
    }
}
