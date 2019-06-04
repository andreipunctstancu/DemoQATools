package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DraggableItemPage;
import testSetup.TestBase;

public class DraggableItemTest extends TestBase {

    private DraggableItemPage draggableItemPage;

    @Override
    @BeforeTest
    public void setupApp (){
        super.setupApp();
        draggableItemPage = PageFactory.initElements(driver, DraggableItemPage.class);
    }

    @BeforeMethod
    public void openPage () {
        openUrl("https://demoqa.com/draggable/");
    }

    @Test
    public void canBeDragged () {
        String initLocation = draggableItemPage.getLocation();

        dragElementBy100Px(draggableItemPage.draggableItem);

        String  finalLocation = draggableItemPage.getLocation();

        Assert.assertFalse(initLocation.equals(finalLocation));
    }
}
