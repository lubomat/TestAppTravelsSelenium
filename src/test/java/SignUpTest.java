import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

        String lastName = "Testowany";
        int randomNumber = (int) (Math.random()*1000);
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
        driver.findElement(By.name("email")).sendKeys("Testowalny"+randomNumber+"@test.pl");
        driver.findElement(By.name("password")).sendKeys("haslotestowe123");
        driver.findElement(By.name("confirmpassword")).sendKeys("haslotestowe123");
//        driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[9]/button")).click();
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        WebElement heading = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/div/div/div[1]/h3"));
        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(),"Hi, Andrzej Testowany");

        System.out.println(heading.getText());
        System.out.println("W tym tescie został użyty adres email: " + "Testowalny"+randomNumber+"@test.pl");

        driver.close();

    }
}
