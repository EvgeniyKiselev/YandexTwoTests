package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class TvPage extends BasePage {

    @FindBy(xpath = "//p//input[@id='glpricefrom']")
    public static WebElement priceFrom;

    @FindBy(xpath = "//span[@class='NVoaOvqe58' and text()='LG']")
    public WebElement lg;

    @FindBy(xpath = "//span[@class='NVoaOvqe58' and text()='Samsung']")
    public static WebElement samsung;

    public void turnToTwelve() throws InterruptedException {
        turnCountsToTwelve();
    }

    public void fillFieldPrice(String value) {
        fillField(priceFrom, value);
    }

    public void setCheckboxes(){
        setCheckBoxed(lg);
        setCheckBoxed(samsung);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
}
