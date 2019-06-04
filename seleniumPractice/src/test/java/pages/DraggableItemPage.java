package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggableItemPage   {

    @FindBy(id = "draggable")
    public WebElement draggableItem;


    public String getLocation (){
        int x = draggableItem.getLocation().getX();
        int y = draggableItem.getLocation().getY();
        return x + ", " + y;
    }
}
