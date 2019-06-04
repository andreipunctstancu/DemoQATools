package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectableItemsPage {

    @FindBy(xpath = "//*[@id='selectable']/li[1]")
    public WebElement item1;

    @FindBy(xpath = "//*[@id='selectable']/li[2]")
    public WebElement item2;

    @FindBy(xpath = "//*[@id='selectable']/li[3]")
    public WebElement item3;

    @FindBy(xpath = "//*[@id='selectable']/li[4]")
    public WebElement item4;

    @FindBy(xpath = "//*[@id='selectable']/li[5]")
    public WebElement item5;

    @FindBy(xpath = "//*[@id='selectable']/li[6]")
    public WebElement item6;

    @FindBy(xpath = "//*[@id='selectable']/li[7]")
    public WebElement item7;

    public void selectItembyClick (WebElement element){
        element.click();
    }

    public boolean checkIfElementIsSelected (WebElement element){
        if (element.getAttribute("class").contains("ui-selected")){
            return true;
        }return false;
    }

}
