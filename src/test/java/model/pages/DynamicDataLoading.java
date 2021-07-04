package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DynamicDataLoading {

    private WebDriver driver;
    private By addNewBtnSelector = By.cssSelector("button#save");

    public DynamicDataLoading(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddNewBtn() {
        driver.findElement(addNewBtnSelector).click();
    }

    public boolean checkUser() {
        WebDriverWait wait = new WebDriverWait(driver, 6);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#loading br")));
            List<WebElement> els = driver.findElements(By.cssSelector("div#loading br"));
            System.out.println(els.size());

            return true;

        } catch (TimeoutException e) {
            return false;
        }
    }
}
