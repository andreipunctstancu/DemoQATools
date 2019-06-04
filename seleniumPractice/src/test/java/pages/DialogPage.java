package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DialogPage {

    @FindBy(id = "dialog")
    private WebElement dialog;

    @FindBy(xpath = "/html/body/div[6]/div[1]/button/span[1]")
    private WebElement closeButton;

    public String getTextFromDialog () {
        return dialog.getText();
    }

    public void closeDialog () {
        closeButton.click();
    }

    public boolean checkIfDialogIsClosed () {
        if (dialog.isDisplayed()) {
            return true;
        }
        return false;
    }
}
