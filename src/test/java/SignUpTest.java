import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    @Test
    public void signUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
        driver.get("http://kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        // click MY ACCOUNT
        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        // click Sign UP
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).stream()    //.get(1).click();
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        // entering informations
        driver.findElement(By.name("firstname")).sendKeys("Andrzej");
        driver.findElement(By.name("lastname")).sendKeys("Testowany");
        driver.findElement(By.name("phone")).sendKeys("111222333");
        driver.findElement(By.name("email")).sendKeys("Testowalny123123@test.pl");
        driver.findElement(By.name("password")).sendKeys("haslotestowe123");
//        driver.findElement(By.name("confrimpassword")).sendKeys("haslotestowe123");
        driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[9]/button")).click();
    }
}
