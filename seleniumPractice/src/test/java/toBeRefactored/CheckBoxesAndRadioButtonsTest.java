package toBeRefactored;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testSetup.TestBase;
import java.util.List;

public class CheckBoxesAndRadioButtonsTest extends TestBase {

    @BeforeTest
    public void openApp(){
        openUrl("https://demoqa.com/checkboxradio/");
    }

    @Test
    public void checkIfRadioboxesAreDeselectedByDefault () {
        List <WebElement> allCheckboxes = driver.findElements(By.cssSelector("label"));
                for (WebElement elements:allCheckboxes){
                    if (elements.getAttribute("for").contains("radio"))
                        //System.out.println(elements.getAttribute("class"));
                        Assert.assertFalse(elements.getAttribute("class").contains("ui-state-active"));
                }
    }

    @Test
    public void checkIfRadioBoxIsSelected () {
        WebElement newYorkCheckbox = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/fieldset[1]/label[1]"));
        newYorkCheckbox.click();
        Assert.assertTrue(newYorkCheckbox.getAttribute("class").contains("ui-checkboxradio-checked"));
    }

    @Test
    public void checkIfMultipleCheckboxesCanBeSelected () {
        WebElement parisCheckBox = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/fieldset[1]/label[2]"));
        WebElement londonCheckBox = driver.findElement(By. xpath("//*[@id=\"content\"]/div[2]/div/fieldset[1]/label[3]/span[2]"));
        parisCheckBox.click();
        londonCheckBox.click();

        Assert.assertFalse(parisCheckBox.getAttribute("class").contains("ui-checkboxradio-checked"));
        Assert.assertTrue(londonCheckBox.getAttribute("class").contains("ui-checkboxradio-checked"));

    }
}
