package toBeRefactored;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownMenuTestIncomplete {

    @Test
    public void dragDroppableItemInTargetItem () {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/selectmenu/");
        driver.manage().window().maximize();

        WebElement dropDownMenu = driver.findElement(By.id("speed"));
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.elementToBeClickable(dropDownMenu));
        dropDownMenu.click();

        //WebElement dropDownMenu = dropDownMenuOpener.findElement(By.id("speed"));
        Select dropDown = new Select(dropDownMenu);

        dropDown.selectByIndex(1);
        driver.quit();
    }
}
