package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResizableItemPage {

    @FindBy(id = "resizable")
    public WebElement resizableItem;

    @FindBy(className = "ui-resizable-handle")
    public WebElement resizeHandle;

    public Integer getWidthofResizableElement () {
       return resizableItem.getSize().getWidth();
    }

    public Integer geHeightofResizableElement () {
        return resizableItem.getSize().getHeight();
    }


}
