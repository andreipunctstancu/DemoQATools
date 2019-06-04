package tests;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SelectableItemsPage;
import testSetup.TestBase;

public class SelectableItemsTest extends TestBase {

    private SelectableItemsPage selectableItemsPage;

    @Override
    @BeforeTest
    public void setupApp (){
        super.setupApp();
        selectableItemsPage = PageFactory.initElements(driver, SelectableItemsPage.class);
    }

    @BeforeMethod
    public void openPage () {
        openUrl("https://demoqa.com/selectable/");
    }

    @Test
    public void selectOneItem () {
        selectableItemsPage.selectItembyClick(selectableItemsPage.item1);
        Assert.assertTrue(selectableItemsPage.checkIfElementIsSelected(selectableItemsPage.item1));
    }


    //this test checks if an element from the list can be deselected by double-clicking on it
    @Test
    public void checkIfElementIsDeselectedAtDoubleClick () {
        doubleClickOnElement(selectableItemsPage.item1);
        Assert.assertTrue(selectableItemsPage.checkIfElementIsSelected(selectableItemsPage.item1));
    }

    @Test
    public void canMultipleElementsBeSelectedByClick () {
        selectableItemsPage.selectItembyClick(selectableItemsPage.item1);
        selectableItemsPage.selectItembyClick(selectableItemsPage.item2);

        Assert.assertFalse(selectableItemsPage.item1.getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(selectableItemsPage.item2.getAttribute("class").contains("ui-selected"));
    }

}
