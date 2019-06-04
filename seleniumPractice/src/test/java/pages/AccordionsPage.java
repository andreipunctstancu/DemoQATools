package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccordionsPage {

    @FindBy(id = "ui-id-1")
    private WebElement firstAccordion;

    @FindBy(id = "ui-id-3")
    private WebElement secondAccordion;

    @FindBy(id = "ui-id-5")
    private WebElement thirdAccordion;

    @FindBy(id = "ui-id-7")
    private WebElement fourthAccordion;

    public boolean isFirstAccordionOpenedByDefault () {
        if (firstAccordion.getAttribute("aria-selected").equals("true") && firstAccordion.getAttribute("aria-expanded").equals("true")) {
            return true;
        }
        return false;
    }

    public String canAccordionsBeCollapsedByClick () {
        //first, an accordion will be selected
        secondAccordion.click();
        //then, a click action will be again performed on it
        secondAccordion.click();

        return secondAccordion.getAttribute("aria-expanded");
    }






}
