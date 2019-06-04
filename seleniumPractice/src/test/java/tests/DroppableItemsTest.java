package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DroppableItemPage;
import testSetup.TestBase;

public class DroppableItemsTest extends TestBase {

    private DroppableItemPage droppableItemPage;

    @Override
    @BeforeTest
    public void setupApp () {
        super.setupApp();
        droppableItemPage = PageFactory.initElements(driver, DroppableItemPage.class);
    }

    @BeforeMethod
    public void openPage () {
        openUrl("https://demoqa.com/droppable/");
    }

    @Test
    public void canDragDroppableItemInTargetItem () {
        dragElementIntoTargetItem(droppableItemPage.itemToBeDragged, droppableItemPage.targetItem);
        Assert.assertTrue(droppableItemPage.getTextFromTargetItem().equals("Dropped!"));
    }

    @Test
    public void canDragTargetItemInDroppableItem () {
        dragElementIntoTargetItem(droppableItemPage.targetItem, droppableItemPage.itemToBeDragged);
        Assert.assertTrue(droppableItemPage.getTextFromTargetItem().equals("Drop here"));
    }
}
