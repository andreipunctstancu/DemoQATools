package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DialogPage;
import testSetup.TestBase;

public class DialogItemTest extends TestBase {

    private DialogPage dialogPage;

    @Override
    @BeforeTest
    public void setupApp () {
        super.setupApp();
        dialogPage = PageFactory.initElements(driver, DialogPage.class);
    }

    @BeforeMethod
    public void openPage () {
        openUrl("https://demoqa.com/dialog/");
    }

    @Test
    public void isTextInDialogDisplayedCorrectly () {
        Assert.assertTrue(dialogPage.getTextFromDialog().equals("This is the default dialog which is useful for displaying information. " +
                                                                "The dialog window can be moved, resized and closed with the 'x' icon."));
    }

    @Test
    public void canCloseDialog () {
        dialogPage.closeDialog();
        Assert.assertFalse(dialogPage.checkIfDialogIsClosed());
    }
}

