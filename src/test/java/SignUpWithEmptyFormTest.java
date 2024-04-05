import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpWithEmptyFormTest {

    @Test
    public void signUpWithEmptyForm() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
        driver.get("http://kurs-selenium.pl/demo/");
        driver.manage().window().maximize();

        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        // click Sign UP
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).stream()    //.get(1).click();
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);


        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        WebElement emailFail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[1]"));
        System.out.println(emailFail.getText());
        Assert.assertTrue(emailFail.isDisplayed());
        Assert.assertEquals(emailFail.getText(), "The Email field is required.");

        WebElement passwordFail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[2]"));
        System.out.println(passwordFail.getText());
        Assert.assertTrue(passwordFail.isDisplayed());
        Assert.assertEquals(passwordFail.getText(), "The Password field is required.");

        WebElement password2Fail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[3]"));
        System.out.println(password2Fail.getText());
        Assert.assertTrue(password2Fail.isDisplayed());
        Assert.assertEquals(password2Fail.getText(), "The Password field is required.");

        WebElement firstNameFail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[4]"));
        System.out.println(firstNameFail.getText());
        Assert.assertTrue(firstNameFail.isDisplayed());
        Assert.assertEquals(firstNameFail.getText(), "The First name field is required.");

        WebElement lastNameFail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[5]"));
        System.out.println(lastNameFail.getText());
        Assert.assertTrue(lastNameFail.isDisplayed());
        Assert.assertEquals(lastNameFail.getText(), "The Last Name field is required.");



        driver.close();

    }
}
