package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


import static org.junit.Assert.assertEquals;
import static util.Init.getDriver;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='header-search']")
    public static WebElement search;

    @FindBy(xpath = "//button[@role='button' and @type='submit']")
    public static WebElement submit;

    @FindBy(xpath = "//button[@role='listbox']")
    public static WebElement listbox;

    @FindBy(xpath = "//span[@class='select__text' and contains(text(), 'Показывать по 12')]")
    public static WebElement chooseTheTwelve;

    public WebElement waitForElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    WebElement waitForClickable(String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public BasePage(){
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void turnCountsToTwelve() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(listbox);
        listbox.click();
        wait.until(ExpectedConditions.visibilityOf(chooseTheTwelve));
        wait.until(ExpectedConditions.elementToBeClickable(chooseTheTwelve));
        chooseTheTwelve.click();
        Thread.sleep(6000);
    }

    public void fillField(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void setCheckBoxed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void checkTheCount(){
        int isTwelve = driver.findElements(By.xpath("//div[contains(@class, 'n-snippet-') and contains(@data-bem,'snippet-card')]")).size();
        if (isTwelve != 12) {
            System.out.println("Количество товаров на странице не равно 12!");
        }
    }

    public String getFirstProduct(){
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        String firstProduct = driver.findElements(By.xpath("//div[contains(@class, 'n-snippet-') and contains(@data-bem,'snippet-card')]//h3//a")).get(0).getText();
        return firstProduct;
    }

    public void searchFirstProduct() {
        fillField(search, getFirstProduct());
        submit.click();
    }

    public void checkFirstIsSearched(){
        String chechedProduct = driver.findElements(By.xpath("//div[contains(@class, 'n-snippet-') and contains(@data-bem,'snippet-card')]//h3//a")).get(0).getText();
        Assert.assertEquals("Наименование товара не соответствует запомненному значению",getFirstProduct(),chechedProduct);
    }

    public void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }
}