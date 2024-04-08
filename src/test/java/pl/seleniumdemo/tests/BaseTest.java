package pl.seleniumdemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.seleniumdemo.utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void searchSetup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();      "chrome"
        driver = DriverFactory.getDriver("firefox");
        driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
        driver.get("http://kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterSetup() {
        driver.quit();
    }
}
