package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.Init.getDriver;

public class MainPage extends BasePage {

    @FindBy(xpath = "//ul[@class = 'lg-menu__list']//button[@class = 'lg-menu__link']/span[contains(text(), 'Страхование')]")
    WebElement menuItems;

    @FindBy(xpath = "//div[@class = 'lg-menu__sub']//a[contains(text(), 'Страхование путешественников')]")
    WebElement menuInsurance;

    public MainPage(){
        this.driver = getDriver();
    }

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMenuItem(){
         WebElement menuItems = driver.findElement(By.xpath("//ul[@class = 'lg-menu__list']//button[@class = 'lg-menu__link']/span[contains(text(), 'Страхование')]"));
         menuItems.click();
    }

    public void selectInsuranceItem(){
        WebElement menuInsurance = driver.findElement(By.xpath("//div[@class = 'lg-menu__sub']//a[contains(text(), 'Страхование путешественников')]"));
        menuInsurance.click();
    }
}
