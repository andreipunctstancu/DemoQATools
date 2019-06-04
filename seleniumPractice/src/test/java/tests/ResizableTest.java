package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ResizableItemPage;
import testSetup.TestBase;

public class ResizableTest extends TestBase {

    private ResizableItemPage resizableItemPage;

    @Override
    @BeforeTest
    public void setupApp () {
        super.setupApp();
        resizableItemPage = PageFactory.initElements(driver, ResizableItemPage.class);
    }

    @BeforeMethod
    public void openPage () {
        openUrl("https://demoqa.com/resizable/");
    }

    @Test
    public void canResizeItem () {
        int initWidth = resizableItemPage.getWidthofResizableElement();
        int initHeight = resizableItemPage.geHeightofResizableElement();

        customWait(1000);

        resizeElementBy100Px(resizableItemPage.resizeHandle, initHeight, initWidth);

        int finalWidth = resizableItemPage.getWidthofResizableElement();
        int finalHeight = resizableItemPage.geHeightofResizableElement();

        Assert.assertFalse(finalHeight == initHeight+100);
        Assert.assertFalse(finalWidth == initWidth+100);
    }
}
