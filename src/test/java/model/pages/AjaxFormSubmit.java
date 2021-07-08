package model.pages;

import model.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AjaxFormSubmit {

    private WebDriver driver;
    private By nameSelector = By.id("title");
    private By commentSelector = By.id("description");
    private By submitBtnSelector = By.id("btn-submit");
    private By noticeMessageSelector = By.id("submit-control");

    public Header headerComponent() {
        return new Header(driver);
    }

    public AjaxFormSubmit(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getNameElement() {
        return this.getDriver().findElement(nameSelector);
    }

    public WebElement getCommentElement() {
        return this.getDriver().findElement(commentSelector);
    }

    public WebElement getSubmitBtnElement() {
        return this.getDriver().findElement(submitBtnSelector);
    }

    public WebElement getNoticeMessageElement() {
        return this.getDriver().findElement(noticeMessageSelector);
    }

    public void enterName(String name) {
        this.getNameElement().sendKeys(name);
    }

    public void enterComment(String comment) {
        this.getCommentElement().sendKeys(comment);
    }

    public void clickOnSubmitBtn() {
        this.getSubmitBtnElement().click();
    }

    public void verifyMessage(String message) {
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 30);
        wait.until(ExpectedConditions.textToBe(noticeMessageSelector, message));
        Assert.assertEquals(this.getNoticeMessageElement().getText(), message);
    }
}
