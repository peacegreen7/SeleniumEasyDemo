package model.pages;

import model.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectListDemo {

    private WebDriver driver;
    private By selectListSelector = By.id("select-demo");
    private By multipleSelectListSelector = By.id("multi-select");
    private By selectValueSelector = By.className("selected-value");
    private By firstBtnSelector = By.id("printMe");
    private By allBtnSelector = By.id("printAll");
    private By selectMessageSelector = By.className("getall-selected");

    public Header headerComponent() {
        return new Header(this.getDriver());
    }


    public SelectListDemo(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getSelectListSelector() {
        return this.getDriver().findElement(selectListSelector);
    }

    public WebElement getMultipleSelectListSelector() {
        return this.getDriver().findElement(multipleSelectListSelector);
    }

    public WebElement getSelectValueSelector() {
        return this.getDriver().findElement(selectValueSelector);
    }

    public WebElement getFirstBtnSelector() {
        return this.getDriver().findElement(firstBtnSelector);
    }

    public WebElement getAllBtnSelector() {
        return this.getDriver().findElement(allBtnSelector);
    }

    public WebElement getSelectMessageSelector() {
        return this.getDriver().findElement(selectMessageSelector);
    }

    public void selectByValue(String value) {
        Select select = new Select(this.getSelectListSelector());
        select.selectByValue(value);
        System.out.println(this.getSelectValueSelector().getText());
    }

    public void selectByIndex(int index) {
        Select select = new Select(this.getSelectListSelector());
        select.selectByIndex(index);
        System.out.println(this.getSelectValueSelector().getText());
    }

    public void selectAllOptions() {
        Select select = new Select(this.getMultipleSelectListSelector());

        if (select.isMultiple()) {
            for (int i = 0; i < 8; i++) {
                select.selectByIndex(i);
            }
            select.getAllSelectedOptions();
            this.getAllBtnSelector().click();
            System.out.println(this.getSelectMessageSelector().getText());
        }
    }

    public void selectFirstOptions() {
        Select select = new Select(this.getMultipleSelectListSelector());

        if (select.isMultiple()) {
            select.selectByIndex(2);
            select.getFirstSelectedOption();
            this.getFirstBtnSelector().click();
            System.out.println(this.getSelectMessageSelector().getText());
        }
    }
}
