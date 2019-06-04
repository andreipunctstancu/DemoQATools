package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TooltipPage {

    @FindBy(id = "age")
    public WebElement inputField;

    @FindBy(className = "ui-tooltip")
    public WebElement toolTip;

    public String getToolTipMessage () {
        return toolTip.getText();
    }

    public boolean isToolTipDisplayed () {
        if (toolTip.isDisplayed()) {
            return true;
        } return false;
    }

}
