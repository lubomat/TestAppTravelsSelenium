package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;

import java.util.List;

public class HotelSearchTest extends BaseTest {


    @Test
    public void searchHotelTest() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.setDates("27/04/2025", "30/04/2025");
        hotelSearchPage.setTravelers(1, 2);
        hotelSearchPage.performSearch();

        ResultsPage resultsPage = new ResultsPage(driver);

        List<String> hotelNames = resultsPage.getHotelNames();


        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");


        // set City
//        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
//        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Dubai");
//        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();
        // set checkin
//        driver.findElement(By.name("checkin")).sendKeys("14/09/2025");
//        driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input")).sendKeys("13/09/2024");
        // set checkout
//        driver.findElement(By.name("checkout")).click();
//        driver.findElements(By.xpath("//td[@class='day ' and text()='30']"))
//                        .stream()
//                        .filter(WebElement::isDisplayed)
//                        .findFirst()
//                        .ifPresent(WebElement::click);
//        driver.findElement(By.id("travellersInput")).click();
        // add adult
//        driver.findElement(By.id("adultPlusBtn")).click();
        // add child
//        driver.findElement(By.id("childPlusBtn")).click();
        // click search
//        driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button")).click();
//        driver.findElement(By.xpath("//button[text()=' Search']")).click();
//


//        List<String> hotelNames = driver.findElements(By.xpath(
//                "//h4[contains(@class,'list_title')]//b")).stream()
//                                    .map(el -> el.getAttribute("textContent"))
//                                    .collect(Collectors.toList());

//        hotelNames.forEach(System.out::println); // kazdy z tych elementow bedzie przekazywany do println


//        System.out.println(hotelNames.size());
//        hotelNames.forEach(el -> System.out.println(el));    // tu tak samo jak wyżej


    }

    @Test
    public void searchHotelWithoutCityTest() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDates("14/09/2025", "22/09/2025");
        hotelSearchPage.setTravelers(0, 1);
        hotelSearchPage.performSearch();

        ResultsPage resultsPage = new ResultsPage(driver);

        Assert.assertTrue(resultsPage.resultHeading.isDisplayed());
        Assert.assertEquals(resultsPage.getHeadingText(), "No Results Found");

        // set checkin
//        driver.findElement(By.name("checkin")).sendKeys("14/09/2025");
//        driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input")).sendKeys("13/09/2024");
        // set checkout
//        driver.findElement(By.name("checkout")).sendKeys("22/09/2025");
//        driver.findElement(By.name("checkout")).click();
//        driver.findElements(By.xpath("//td[@class='day ' and text()='30']"))
//                .stream()
//                .filter(WebElement::isDisplayed)       !!!!!! wybieranie z kalendarza ale tylko dzien   !!!!!
//                .findFirst()
//                .ifPresent(WebElement::click);

//        driver.findElement(By.id("travellersInput")).click();
        // add adult
//        driver.findElement(By.id("adultPlusBtn")).click();
        // add child
//        driver.findElement(By.id("childPlusBtn")).click();
        // click search
//        driver.findElement(By.xpath("//button[text()=' Search']")).click();


    }
}
