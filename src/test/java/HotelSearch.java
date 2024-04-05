import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HotelSearch {

    @Test
    public void searchHotel() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
        driver.get("http://kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        // set City
        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Dubai");
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();
        // set checkin
        driver.findElement(By.name("checkin")).sendKeys("14/09/2025");
//        driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input")).sendKeys("13/09/2024");
        // set checkout
        driver.findElement(By.name("checkout")).click();
        driver.findElements(By.xpath("//td[@class='day ' and text()='30']"))
                        .stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .ifPresent(WebElement::click);
        driver.findElement(By.id("travellersInput")).click();
        // add adult
        driver.findElement(By.id("adultPlusBtn")).click();
        // add child
        driver.findElement(By.id("childPlusBtn")).click();
        // click search
//        driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        List<String> hotelNames = driver.findElements(By.xpath(
                "//h4[contains(@class,'list_title')]//b")).stream()
                                    .map(el -> el.getAttribute("textContent"))
                                    .collect(Collectors.toList());

        hotelNames.forEach(System.out::println); // kazdy z tych elementow bedzie przekazywany do println


        System.out.println(hotelNames.size());
        hotelNames.forEach(el -> System.out.println(el));    // tu tak samo jak wyżej

        Assert.assertEquals(hotelNames.get(0),"Jumeirah Beach Hotel");
        Assert.assertEquals( hotelNames.get(1),"Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3),"Hyatt Regency Perth");

        driver.close();

    }

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
