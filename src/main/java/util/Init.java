package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Init {
    private static WebDriver driver;

    protected static TestProperties properties = TestProperties.getInstance();

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", properties.getProperties("webdriver.chrome.driver"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperties("timeout.global")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(properties.getProperties("timeout.pageLoad")), TimeUnit.SECONDS);
        driver.get(properties.getProperties("url"));
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
    }
}