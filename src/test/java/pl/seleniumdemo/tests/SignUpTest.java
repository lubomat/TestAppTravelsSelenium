package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;

import java.util.List;

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

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(),"Hi, Andrzej Testowany");

        System.out.println(loggedUserPage.getHeadingText());
        System.out.println("W tym tescie został użyty adres email: " + "Testowalny"+randomNumber+"@test.pl");

    }

    @Test
    public void signUpTest2() {

        int randomNumber = (int) (Math.random()*1000);
        String lastName = "Testowany";
        String email = "Testowalny"+randomNumber+"@test.pl";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.fillSignUpForm("Andrzej",lastName,"123123123",
                email,"haslotestowe123");
        

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(),"Hi, Andrzej Testowany");

        System.out.println(loggedUserPage.getHeadingText());
        System.out.println("W tym tescie został użyty adres email: " + "Testowalny"+randomNumber+"@test.pl");

    }

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


    @Test
    public void signUpWithEmptyFormTest() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp();

        List<String> errors = signUpPage.getErrors();
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
    public void signUpInvalidEmailTest() {


        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Andrzej");
        signUpPage.setLastName("Testowany");
        signUpPage.setPhone("123123123");
        signUpPage.setEmail("niepoprawnyemail.pl");
        signUpPage.setPassword("haslotestowe123");
        signUpPage.setConfirmPassword("haslotestowe123");
        signUpPage.signUp();

        Assert.assertTrue(signUpPage.getErrors().contains(
                "The Email field must contain a valid email address."));


    }
}
