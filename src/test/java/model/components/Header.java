package model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {

    private WebDriver webDriver;
    private By inputFormMenuSelector = By.xpath("//div[@id='navbar-brand-centered']/descendant::a[contains(text(), 'Input Forms')]");
    private By DatePickerSelector = By.xpath("//div[@id='navbar-brand-centered']/descendant::a[contains(text(), 'Date pickers')]");
    private By TableSelector = By.xpath("//div[@id='navbar-brand-centered']/descendant::a[contains(text(), 'Table')]");
    private By DemoHomeMenuSelector = By.xpath("//a[contains(text(), 'Demo Home')]");
    private By ProgressBarMenuSelector = By.xpath("//div[@id='navbar-brand-centered']/descendant::a[contains(text(), 'Progress Bars')]");
    private By AlertModalMenuSelector = By.xpath("//div[@id='navbar-brand-centered']/descendant::a[contains(text(), 'Alert & Modals')]");
    private By ListBoxSelector = By.xpath("//div[@id='navbar-brand-centered']/descendant::a[contains(text(), 'List Box')]");
    private By OtherMenuSelector = By.xpath("//div[@id='navbar-brand-centered']/descendant::a[contains(text(), 'Others')]");

    private By verifyContentPageSelector = By.cssSelector("div#easycont h3");

    public Header (WebDriver webdriver) {
        this.webDriver = webdriver;
    }


    public void selectInputFormsOption(WebDriver driver, String option) {

        driver.findElement(inputFormMenuSelector).click();
        WebElement webElement = driver.findElement(By.xpath("//a[contains(text(), 'Input Forms')]/ancestor::div[@id='navbar-brand-centered']/descendant::a[text()='" + option + "']"));
        webElement.click();

    }

    public String getVerifyContentPage(WebDriver driver) {
         return driver.findElement(verifyContentPageSelector).getText();
    }


}
