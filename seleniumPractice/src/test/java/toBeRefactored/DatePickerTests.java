package toBeRefactored;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePickerTests {

    @Test
    public void dragDroppableItemInTargetItem () {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/draggable/");
        driver.manage().window().maximize();
    }
}
