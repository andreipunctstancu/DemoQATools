package toBeRefactored;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testSetup.TestBase;

public class SpinnerTest extends TestBase {


    @BeforeTest
    public void openApp(){
        openUrl("https://demoqa.com/spinner/");
    }


    @Test
    public void checkIfInputFieldIsEmptyByDefault () {
        WebElement inputField = driver.findElement(By.id("spinner"));
        Assert.assertTrue(inputField.getText().equals(""));
    }

//    @Test
//    public void checkIfInputFIeldAcceptsAlphabeticalAndSpecialCharacters () {
//        WebElement inputField = driver.findElement(By.id("spinner"));
//        WebElement getValueButton = driver.findElement(By.id("getvalue"));
//
//        inputField.sendKeys("asd!@");
//        getValueButton.click();
//    }

    @Test
    public void checkToggleEnabling () {
        WebElement spinnerDownButton = driver.findElement(By.className("ui-spinner-down"));
        WebElement spinnerUpButton = driver.findElement(By.className("ui-spinner-up"));
        WebElement enableButton = driver.findElement(By.id("disable"));

        //checking if clicking the "Toggle enable/disable" button at first disables the toggle
        enableButton.click();
        Assert.assertTrue(spinnerDownButton.getAttribute("class").contains("ui-state-disabled"));
        Assert.assertTrue(spinnerUpButton.getAttribute("class").contains("ui-state-disabled"));

        //checking if clicking "Toggle enable/disable" button when the toggle is disabled will make it enabled
        enableButton.click();
        Assert.assertFalse(spinnerDownButton.getAttribute("class").contains("ui-state-disabled"));
        Assert.assertFalse(spinnerUpButton.getAttribute("class").contains("ui-state-disabled"));
    }

    @Test
    public void checkToggleDisplayingConditions () throws InterruptedException {
        WebElement spinnerDownButton = driver.findElement(By.className("ui-spinner-down"));
        WebElement spinnerUpButton = driver.findElement(By.className("ui-spinner-up"));
        WebElement toggleWidgetButton = driver.findElement(By.id("destroy"));

        //checking if clicking the "Toggle widget" button at first hides the toggle
        toggleWidgetButton.click();

        WebDriverWait wait = new WebDriverWait(driver,2);
        boolean isSpinnerDownHidden = wait.until(ExpectedConditions.invisibilityOf(spinnerDownButton));
        boolean isSpinnerUpHidden = wait.until(ExpectedConditions.invisibilityOf(spinnerUpButton));

        Assert.assertTrue(isSpinnerDownHidden);
        Assert.assertTrue(isSpinnerUpHidden);

        //checking if clicking again on the "Toggle widget button" will make the toggle visible
        toggleWidgetButton.click();
    }

    @Test
    public void checkIfValueIsSetToFive () {
        WebElement inputField = driver.findElement(By.id("spinner"));
        WebElement setValueTo5Button = driver.findElement(By.id("setvalue"));

        setValueTo5Button.click();

        System.out.println(inputField.getText());

        Assert.assertTrue(inputField.getText().equals("5"));
    }


}
