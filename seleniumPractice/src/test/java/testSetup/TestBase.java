package testSetup;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestBase {

    public WebDriver driver;

    @BeforeTest
    public void setupApp () {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown () {
        driver.quit();
        driver = null;
    }

    public void openUrl (String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void customWait (int time){
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
        }
    }


    public void dragElementBy100Px (WebElement toBeDragged) {
        Actions drag = new Actions(driver);
        drag.dragAndDropBy(toBeDragged,100,100).build().perform();
    }

    public void dragElementIntoTargetItem (WebElement toDrag, WebElement target) {
        Actions dragging = new Actions(driver);
        dragging.dragAndDrop(toDrag, target).build().perform();
    }

    public void resizeElementBy100Px (WebElement element, int x, int y) {
        Actions resize = new Actions (driver);
        resize.clickAndHold(element).moveByOffset(x+100, y+100).release().build().perform();
    }

    public void setSliderToASpecificValue (String jsLocator, Integer value ) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript(jsLocator + value +  "%'");
        Thread.sleep(2000);}

    public void hoverMouseOverElement (WebElement element) {
        Actions hoverMouse = new Actions(driver);
        hoverMouse.moveToElement(element).build().perform();
    }

    public void doubleClickOnElement (WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }

    public void waitUntilAnElementIsClickable (WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
