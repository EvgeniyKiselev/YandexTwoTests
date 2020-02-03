package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Init;

import java.util.concurrent.TimeUnit;

import static util.Init.getDriver;

public class TvPage extends BasePage {

    @FindBy(xpath = "//p//input[@id='glpricefrom']")
    public static WebElement priceFrom;

    @FindBy(xpath = "//span[@class='NVoaOvqe58' and text()='LG']")
    public WebElement lg;

    @FindBy(xpath = "//span[@class='NVoaOvqe58' and text()='Samsung']")
    public static WebElement samsung;


    public void fillField(String fieldName, String value) {
        fillField(priceFrom, value);
    }

    public void setCheckboxes(){
        setCheckBoxed(lg);
        setCheckBoxed(samsung);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void checkTheCount(){
        int isTwelve = driver.findElements(By.xpath("//div[contains(@class, 'n-snippet-') and contains(@data-bem,'snippet-card')]")).size();
        if (isTwelve != 12) {
            System.out.println("Количество товаров на странице не равно 12!");
        }
    }

//11. Запомнить первый элемент в списке.
//
//12. В поисковую строку ввести запомненное значение.
//
//13. Найти и проверить, что наименование товара соответствует запомненному значению.



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

    public TvPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public TvPage(){
        this.driver = getDriver();
    }

    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(Init.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='sxrttPxJA0 a6VijDBKnU']"))));
    }
}
