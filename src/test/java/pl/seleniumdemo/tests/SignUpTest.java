package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.SignUpPage;
import pl.seleniumdemo.tests.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {

        String lastName = "Testowany";
        int randomNumber = (int) (Math.random()*1000);

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Andrzej");
        signUpPage.setLastName(lastName);
        signUpPage.setPhone("123123123");
        signUpPage.setEmail("Testowalny"+randomNumber+"@test.pl");
        signUpPage.setPassword("haslotestowe123");
        signUpPage.setConfirmPassword("haslotestowe123");
        signUpPage.signUp();


        // click MY ACCOUNT
//        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
//                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        // click Sign UP
//        driver.findElements(By.xpath("//a[text()='  Sign Up']")).stream()    //.get(1).click();
//                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        // entering informations
//        driver.findElement(By.name("firstname")).sendKeys("Andrzej");
//        driver.findElement(By.name("lastname")).sendKeys("Testowany");
//        driver.findElement(By.name("phone")).sendKeys("111222333");
//        driver.findElement(By.name("email")).sendKeys("Testowalny"+randomNumber+"@test.pl");
//        driver.findElement(By.name("password")).sendKeys("haslotestowe123");
//        driver.findElement(By.name("confirmpassword")).sendKeys("haslotestowe123");
//        driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[9]/button")).click();
//        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        WebElement heading = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/div/div/div[1]/h3"));
        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(),"Hi, Andrzej Testowany");

        System.out.println(heading.getText());
        System.out.println("W tym tescie został użyty adres email: " + "Testowalny"+randomNumber+"@test.pl");



    }


    @Test
    public void signUpWithEmptyFormTest() {

        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        // click Sign UP
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).stream()    //.get(1).click();
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        List<String> errors = driver.findElements(By.xpath(
                "//div[@Class='alert alert-danger']//p"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        Assert.assertTrue(errors.contains("The Email field is required."));
        Assert.assertTrue(errors.contains("The Password field is required."));
        Assert.assertTrue(errors.contains("The Password field is required."));
        Assert.assertTrue(errors.contains("The First name field is required."));
        Assert.assertTrue(errors.contains("The Last Name field is required."));


//        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
//
//        WebElement emailFail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[1]"));
//        System.out.println(emailFail.getText());
//        Assert.assertTrue(emailFail.isDisplayed());
//        Assert.assertEquals(emailFail.getText(), "The Email field is required.");
//
//        WebElement passwordFail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[2]"));
//        System.out.println(passwordFail.getText());
//        Assert.assertTrue(passwordFail.isDisplayed());
//        Assert.assertEquals(passwordFail.getText(), "The Password field is required.");
//
//        WebElement password2Fail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[3]"));
//        System.out.println(password2Fail.getText());
//        Assert.assertTrue(password2Fail.isDisplayed());
//        Assert.assertEquals(password2Fail.getText(), "The Password field is required.");
//
//        WebElement firstNameFail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[4]"));
//        System.out.println(firstNameFail.getText());
//        Assert.assertTrue(firstNameFail.isDisplayed());
//        Assert.assertEquals(firstNameFail.getText(), "The First name field is required.");
//
//        WebElement lastNameFail = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p[5]"));
//        System.out.println(lastNameFail.getText());
//        Assert.assertTrue(lastNameFail.isDisplayed());
//        Assert.assertEquals(lastNameFail.getText(), "The Last Name field is required.");




    }


    @Test
    public void signUpWithBadEmailTest() {

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
        driver.findElement(By.name("email")).sendKeys("niepoprawny"+randomNumber+".pl");
        driver.findElement(By.name("password")).sendKeys("haslotestowe123");
        driver.findElement(By.name("confirmpassword")).sendKeys("haslotestowe123");
//        driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[9]/button")).click();
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        WebElement invalidEmailInfo = driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div/p"));
        System.out.println(invalidEmailInfo.getText());
        Assert.assertTrue(invalidEmailInfo.isDisplayed());
        Assert.assertEquals(invalidEmailInfo.getText(), "The Email field must contain a valid email address.");



    }
}
