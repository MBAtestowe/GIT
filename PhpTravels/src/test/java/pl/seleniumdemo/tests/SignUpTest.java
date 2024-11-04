package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.model.User;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;
import pl.seleniumdemo.tests.BaseTest;
import pl.seleniumdemo.utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {

        String lastName = "Nowak";
        int randomNumber = (int) (Math.random() * 1000);

        LoggedUserPage loggedUserPage = new HotelSearchPage(driver)
                .signUpForm()
                .setFirstName("Anna")
                .setLastName(lastName)
                .setPhoneName("8598561239")
                .setEmailName("anna" + randomNumber + "@gmail.com")
                .setPasswordName("Anowak123")
                .confirmPasswordName("Anowak123")
                .signUp();

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Anna Nowak");
    }

   // @Test
    public void signUpTest2() {

        int randomNumber = (int) (Math.random() * 1000);
        String email = "anna" + randomNumber + "@gmail.com";

        User user = new User();
        user.setFirstName("Anna");
        user.setLastName("Nowak");
        user.setPhone("111111");
        user.setEmail("Anowak12345@gmail.com");
        user.setPassword("Anowa1234");

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.signUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        //signUpPage.fillSignUpForm("Anna", "Nowak", "1111111", "Anowak123@gmail.com","Anowak123");
        signUpPage.fillSignUpForm(user);

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(user.getLastName()));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Anna Nowak");
    }

    @Test
    public void emailAlreadyExistsTest() {
        SignUpPage signUpPage = new HotelSearchPage(driver)
                .signUpForm()
                .setFirstName("Anna")
                .setLastName("Nowak")
                .setPhoneName("8598561239")
                .setEmailName("anowak@gmail.com")
                .setPasswordName("Anowak123")
                .confirmPasswordName("Anowak123");
        signUpPage.signUp();

        Assert.assertTrue(signUpPage.emailAlreadyExists().contains("Email Already Exists."));
    }

    @Test
    public void emptyFormTest() {
        SignUpPage signUpPage = new HotelSearchPage(driver).signUpForm();
        signUpPage.signUp();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signUpPage.errorsText().contains("The Email field is required."));
        softAssert.assertTrue(signUpPage.errorsText().contains("The Password field is required."));
        softAssert.assertTrue(signUpPage.errorsText().contains("The Password field is required."));
        softAssert.assertTrue(signUpPage.errorsText().contains("The First name field is required."));
        softAssert.assertTrue(signUpPage.errorsText().contains("The Last Name field is required."));
        softAssert.assertAll();
    }

    @Test
    public void unvalidEmailTest() {
        SignUpPage signUpPage = new HotelSearchPage(driver)
                .signUpForm()
                .setFirstName("Anna")
                .setLastName("Nowak")
                .setPhoneName("8598561239")
                .setEmailName("anowakgmail.com")
                .setPasswordName("Anowak123")
                .confirmPasswordName("Anowak123");
        signUpPage.signUp();

        Assert.assertTrue(signUpPage.errorsText().contains("The Email field must contain a valid email address."));
    }
}
