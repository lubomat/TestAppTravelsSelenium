import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelSearchWithoutCityTest {

    @Test
    public void searchHotelWithoutCity() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
        driver.get("http://kurs-selenium.pl/demo/");
        driver.manage().window().maximize();

        // set checkin
        driver.findElement(By.name("checkin")).sendKeys("14/09/2025");
//        driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input")).sendKeys("13/09/2024");
        // set checkout
        driver.findElement(By.name("checkout")).sendKeys("22/09/2025");
//        driver.findElement(By.name("checkout")).click();
//        driver.findElements(By.xpath("//td[@class='day ' and text()='30']"))
//                .stream()
//                .filter(WebElement::isDisplayed)       !!!!!! wybieranie z kalendarza ale tylko dzien   !!!!!
//                .findFirst()
//                .ifPresent(WebElement::click);

        driver.findElement(By.id("travellersInput")).click();
        // add adult
        driver.findElement(By.id("adultPlusBtn")).click();
        // add child
        driver.findElement(By.id("childPlusBtn")).click();
        // click search
        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        WebElement noResult = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div[1]/div[3]/div/div/h2"));
        System.out.println(noResult.getText());

        Assert.assertTrue(noResult.isDisplayed());
        Assert.assertEquals(noResult.getText(),"No Results Found");

        driver.close();

    }
}
