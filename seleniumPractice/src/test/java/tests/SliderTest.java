package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SliderPage;
import testSetup.TestBase;

public class SliderTest extends TestBase {

    private SliderPage sliderPage;

    @Override
    @BeforeTest
    public void setupApp () {
        super.setupApp();
        sliderPage = PageFactory.initElements(driver, SliderPage.class);
    }

    @BeforeMethod
    public void openPage () {
        openUrl("https://demoqa.com/droppable/");
    }

    @Test
    public void checkDefaultStateOfSlider () {
        Assert.assertTrue(sliderPage.getSliderValue().equals("left: 0%;"));
    }

    @Test
    public void canSliderBeSetToSpecificValue () throws InterruptedException {
        setSliderToASpecificValue("document.getElementsByClassName('ui-slider-handle')[0].style.left='", 15);
        Assert.assertTrue(sliderPage.getSliderValue().equals("left: " + 15 + "%;"));
    }
}
