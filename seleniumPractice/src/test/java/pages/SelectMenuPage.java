package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage {

    @FindBy(xpath = "//*[@id='menu']/li[1]")
    public WebElement disabledItem;

    @FindBy(id = "ui-id-2")
    public WebElement enabledItem;

    @FindBy(id = "ui-id-4")
    public WebElement firstElementInNavigationChain;

    @FindBy(id = "ui-id-6")
    public WebElement secondElementInNavigationChain;

    public String checkIfElementIsDisabled (WebElement element){
        return element.getAttribute("aria-disabled");
    }

    public String checkIfElementIsSelected (WebElement element){
        return element.getAttribute("class");
    }
}
