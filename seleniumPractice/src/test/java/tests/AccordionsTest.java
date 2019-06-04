package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccordionsPage;
import testSetup.TestBase;

public class AccordionsTest extends TestBase {

    private AccordionsPage accordionsPage;

    @Override
    @BeforeTest
    public void setupApp () {
        super.setupApp();
        accordionsPage = PageFactory.initElements(driver, AccordionsPage.class);
    }

    @BeforeMethod
    public void openPage () {
        openUrl("https://demoqa.com/accordion/");
    }

    @Test
    public void checkIfFirstAccordionIsOpenedByDefault () {
        Assert.assertTrue(accordionsPage.isFirstAccordionOpenedByDefault());
    }

    @Test
    public void checkIfAnAccordionCanBeClosedByDoubleClick () {
        accordionsPage.canAccordionsBeCollapsedByClick();
        Assert.assertTrue(accordionsPage.canAccordionsBeCollapsedByClick().equals("true"));
    }

//    also check that the tab panel of clicked accordion is opened
}
