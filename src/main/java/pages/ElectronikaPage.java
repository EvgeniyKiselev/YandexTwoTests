package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;
import util.Init;

import static util.Init.getDriver;


public class ElectronikaPage extends BasePage {
    @FindBy(xpath = "//a[@href = '/catalog--televizory/59601/list?hid=90639']")
    public static WebElement tv;

    @FindBy(xpath = "/catalog--naushniki-i-bluetooth-garnitury/56179/list?hid=90555")
    public WebElement phones;


    public void selectTv(){
        waitSendAppClickable();
        WebElement tv = driver.findElement(By.xpath("//a[@href = '/catalog--televizory/59601/list?hid=90639"));
        tv.click();
    }

    public void selectPhones(){
        waitSendAppClickable();
        WebElement phones = driver.findElement(By.xpath("/catalog--naushniki-i-bluetooth-garnitury/56179/list?hid=90555"));
        phones.click();
    }

    public ElectronikaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

   public ElectronikaPage(){
       this.driver = getDriver();
   }

    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(Init.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='sxrttPxJA0 a6VijDBKnU']"))));
    }
}
