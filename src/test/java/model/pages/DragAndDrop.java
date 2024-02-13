package model.pages;

import model.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragAndDrop {

    private WebDriver driver;
    private By dragItemSelector = By.xpath("//div[@id='todrag']/child::span");
    private By dropzoneSelector = By.id("mydropzone");
    private By droppedItemSelector = By.xpath("//div[@id='droppedlist']/child::span");

    public Header getHeaderComponent(WebDriver driver) {
        return new Header(driver);
    }

    public DragAndDrop(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public List<WebElement> getDragItemsList() {
        return this.getDriver().findElements(dragItemSelector);
    }

    public WebElement getDragItem() {
        return this.getDriver().findElement(By.xpath("//div[@id='todrag']/child::span[1]"));
    }

    public WebElement getDropzone() {
        return this.getDriver().findElement(dropzoneSelector);
    }

    public List<WebElement> getDroppedItemList() {
        return this.getDriver().findElements(droppedItemSelector);
    }

    public void dragElement() {
        List<WebElement> items = this.getDragItemsList();

        Actions action = new Actions(this.getDriver());
        action.dragAndDrop(this.getDragItem(), this.getDropzone()).build().perform();

//        for(int i = 1; i <= items.size(); i++) {
//            Actions action = new Actions(this.getDriver());
//            action.dragAndDrop(items.get(i), this.getDropzone()).build().perform();
//
//
//
////            //Creating object of Actions class to build composite actions
////            Actions builder = new Actions(driver);
////
////            //Building a drag and drop action
////            Action dragAndDrop = builder.clickAndHold(items.get(i))
////                    .moveToElement(this.getDropzone())
////                    .release(this.getDropzone())
////                    .build();
////
////            //Performing the drag and drop action
////            dragAndDrop.perform();
//        }
    }
}
