package toBeRefactored;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SelectMenuPage;
import testSetup.TestBase;

public class SelectMenuTest extends TestBase {
    private SelectMenuPage selectMenuPage;

    @Override
    @BeforeTest
    public void setupApp() {
        super.setupApp();
        selectMenuPage = PageFactory.initElements(driver, SelectMenuPage.class);
    }

    @BeforeMethod
    public void openPage() {
        openUrl("https://demoqa.com/menu/");
    }

    @Test
    public void checkIfElementIsDisabled() {
        String elementStatus = selectMenuPage.checkIfElementIsDisabled(selectMenuPage.disabledItem);
        Assert.assertTrue(elementStatus.equals("true"));
    }

    @Test
    public void selectUnchainedMenuItem() {
        hoverMouseOverElement(selectMenuPage.enabledItem);
        String isElementSelected = selectMenuPage.checkIfElementIsSelected(selectMenuPage.enabledItem);
        Assert.assertTrue(isElementSelected.contains("ui-state-active"));

    }

    @Test
    public void selectChainedMenuItem() {
        hoverMouseOverElement(selectMenuPage.firstElementInNavigationChain);
        waitUntilAnElementIsClickable(selectMenuPage.secondElementInNavigationChain);
        hoverMouseOverElement(selectMenuPage.secondElementInNavigationChain);

        String isChainedElementSelected = selectMenuPage.checkIfElementIsSelected(selectMenuPage.secondElementInNavigationChain);
        Assert.assertTrue(isChainedElementSelected.contains("ui-state-active"));
    }

}
