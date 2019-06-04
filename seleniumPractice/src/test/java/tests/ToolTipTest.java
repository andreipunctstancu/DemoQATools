package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.TooltipPage;
import testSetup.TestBase;

public class ToolTipTest extends TestBase {

    private TooltipPage tooltipPage;

    @Override
    @BeforeTest
    public void setupApp () {
        super.setupApp();
        tooltipPage = PageFactory.initElements(driver, TooltipPage.class);
    }

    @BeforeMethod
    public void openPage () {
        openUrl("https://demoqa.com/tooltip/");
    }

    @Test
    public void checkToolTipMessage () {
        hoverMouseOverElement(tooltipPage.inputField);
        Assert.assertTrue(tooltipPage.isToolTipDisplayed());
        Assert.assertEquals(tooltipPage.getToolTipMessage(), "We ask for your age only for statistical purposes.");
    }
}
