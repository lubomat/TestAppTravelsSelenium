import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelSearch {

    @Test
    public void searchHotel() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Dubai");

//        WebElement search = driver.findElement(By.id("s2id_autogen9"));
//        search.sendKeys("Dubai");

        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();

//        WebElement checkIn = driver.findElement(By.name("checkin"));
//        checkIn.sendKeys("13/09/2024");

    }
}
