package model.pages;

import model.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RadioButtonDemo {

    private WebDriver driver;
    private By maleOptionSelector = By.xpath("//input[@value='Male' and @name='optradio']");
    private By femaleOptionSelector = By.xpath("//input[@value='Female' and @name='optradio']");
    private By checkValueBtnSelector = By.id("buttoncheck");
    private By pageTitleSelector = By.xpath("h3");
    private By checkValueMessageSelector = By.xpath("//*[@id='buttoncheck']/ancestor::p/following-sibling::p");
    private String noCheckText = "Radio button is Not checked";
    private String maleCheckText = "Radio button 'Male' is checked";
    private String femaleCheckText = "Radio button 'Female' is checked";


    public Header headerComponent(WebDriver driver) {
        return new Header(driver);
    }

    public RadioButtonDemo(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getMaleOptionSelector() {
        return this.getDriver().findElement(maleOptionSelector);
    }

    public WebElement getFemaleOptionSelector() {
        return this.getDriver().findElement(femaleOptionSelector);
    }

    public WebElement getCheckValueBtnSelector() {
        return this.getDriver().findElement(checkValueBtnSelector);
    }

    public WebElement getCheckValueMessageSelector() {
        return this.getDriver().findElement(checkValueMessageSelector);
    }

    public WebElement getPageTitleSelector() {
        return this.getDriver().findElement(pageTitleSelector);
    }

    public void selectOption(String option) {
        if (option.equalsIgnoreCase("male")) {
            this.getMaleOptionSelector().click();
        } else if (option.equalsIgnoreCase("female")) {
            this.getFemaleOptionSelector().click();
        } else {
            System.out.println("Input wrong option. Please enter again.");
        }
    }

    public void validateCheckValue() {
        this.getCheckValueBtnSelector().click();
        if (this.getMaleOptionSelector().isSelected()) {
            Assert.assertEquals(this.getCheckValueMessage(), maleCheckText);
            System.out.println(this.getCheckValueMessage());
        } else if (this.getFemaleOptionSelector().isSelected()) {
            Assert.assertEquals(this.getCheckValueMessage(), femaleCheckText);
            System.out.println(this.getCheckValueMessage());
        } else {
            Assert.assertEquals(this.getCheckValueMessage(), noCheckText);
            System.out.println(this.getCheckValueMessage());
        }

    }

    public String getCheckValueMessage() {
        return this.getCheckValueMessageSelector().getText();
    }

}
