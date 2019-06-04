package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppableItemPage {

    @FindBy (id = "draggable")
    public WebElement itemToBeDragged;

    @FindBy (id = "droppable")
    public WebElement targetItem;

    public String getTextFromTargetItem () {
        return targetItem.getText();
    }
}
