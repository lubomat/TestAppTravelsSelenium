package pl.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;
import pl.seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;
import java.util.List;

public class HotelSearchTest extends BaseTest {


    @Test
    public void searchHotelTest() throws IOException {

        ExtentTest test = extentReports.createTest("Search Hotel Test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        test.log(Status.PASS,"Setting city done", SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setDates("27/04/2025", "30/04/2025");
        test.log(Status.PASS,"Setting dates done",SeleniumHelper.getScreenshot(driver));

        hotelSearchPage.setTravelers(1, 2);
        test.log(Status.PASS,"Setting travelers done",SeleniumHelper.getScreenshot(driver));

        hotelSearchPage.performSearch();
        test.log(Status.PASS,"Performing Search done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Screenshot", SeleniumHelper.getScreenshot(driver));


        ResultsPage resultsPage = new ResultsPage(driver);

        List<String> hotelNames = resultsPage.getHotelNames();


        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
        test.log(Status.PASS,"Assertions passed", SeleniumHelper.getScreenshot(driver));



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
    public void searchHotelWithoutCityTest() throws IOException {

        ExtentTest test = extentReports.createTest("Search Hotel Test Without City");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDates("14/09/2025", "22/09/2025");
        test.log(Status.PASS,"Setting dates done", SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setTravelers(0, 1);
        test.log(Status.PASS,"Setting travelers done", SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.performSearch();
        test.log(Status.PASS,"Performing search done", SeleniumHelper.getScreenshot(driver));

        ResultsPage resultsPage = new ResultsPage(driver);

        Assert.assertTrue(resultsPage.resultHeading.isDisplayed());
        Assert.assertEquals(resultsPage.getHeadingText(), "No Results Found");
        test.log(Status.PASS,"Assertion done", SeleniumHelper.getScreenshot(driver));

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
