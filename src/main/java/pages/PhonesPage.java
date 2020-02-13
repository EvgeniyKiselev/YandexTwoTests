package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class PhonesPage extends BasePage {
    @FindBy(xpath = "//p//input[@id='glpricefrom']")
    private static WebElement priceFrom;

    @FindBy(xpath = "//span[@class='NVoaOvqe58' and text()='Beats']")
    private WebElement beats;

    public void turnToTwelve() throws InterruptedException {
        turnCountsToTwelve();
    }

    public void fillFieldPrice(String value) {
        fillField(priceFrom, value);
    }

    public void setCheckboxes() {
        setCheckBoxed(beats);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
