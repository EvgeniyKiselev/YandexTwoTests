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


public class SberPage extends BasePage {
    @FindBy(xpath = "//span/../../..//h2[contains(text(), 'Страхование путешественников')]")
    public static WebElement h2;

    @FindBy(xpath = "//b[contains(text(), 'Оформить онлайн')]")
    public WebElement sendToPolicy;

    public WebElement checkH2(){
        WebElement h2 = driver.findElement(By.xpath("//span/../../..//h2[contains(text(), 'Страхование путешественников')]"));
        h2.equals("Страхование путешественников");
        return h2;
    }

    public void selectSendToPolicy(){
        waitSendAppClickable();
        WebElement sendToPolicy = driver.findElement(By.xpath("//b[contains(text(), 'Оформить онлайн')]"));
        sendToPolicy.click();
    }

    public SberPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

   public SberPage(){
       this.driver = getDriver();
   }

    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(Init.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//b[contains(text(), 'Оформить онлайн')]"))));
    }
}
