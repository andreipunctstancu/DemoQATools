package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage {

    @FindBy(className = "ui-slider-handle")
    private WebElement sliderHandler;

    public String getSliderValue () {
        return sliderHandler.getAttribute("style");
    }


}
