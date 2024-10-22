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

import java.util.List;
import java.util.stream.Collectors;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest(){

        String lastName = "Nowak";
        int randomNumber = (int) (Math.random()*1000);
        String email = "anna" + randomNumber + "@gmail.com";
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.signUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Anna");
        signUpPage.setLastName(lastName);
        signUpPage.setPhoneName("8598561239");
        signUpPage.setEmailName(email);
        signUpPage.setPasswordName("Anowak123");
        signUpPage.confirmPasswordName("Anowak123");
        signUpPage.signUp();

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);

        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Anna Nowak");
    }
    @Test
    public void signUpTest2(){

        int randomNumber = (int) (Math.random()*1000);
        String email = "anna" + randomNumber + "@gmail.com";

        User user = new User();
        user.setFirstName("Anna");
        user.setLastName("Nowak");
        user.setPhone("111111");
        user.setEmail("Anowak1234@gmail.com");
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
    public void emailAlreadyExistsTest(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.signUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Anna");
        signUpPage.setLastName("Nowak");
        signUpPage.setPhoneName("8598561239");
        signUpPage.setEmailName("anowak@gmail.com");
        signUpPage.setPasswordName("Anowak123");
        signUpPage.confirmPasswordName("Anowak123");
        signUpPage.signUp();

        Assert.assertTrue(signUpPage.emailAlreadyExists().contains("Email Already Exists."));
    }
    @Test
    public void emptyFormTest(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.signUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
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
    public void unvalidEmailTest(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.signUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Anna");
        signUpPage.setLastName("Nowak");
        signUpPage.setPhoneName("8598561239");
        signUpPage.setEmailName("anowakgmail.com");
        signUpPage.setPasswordName("Anowak123");
        signUpPage.confirmPasswordName("Anowak123");
        signUpPage.signUp();

        Assert.assertTrue(signUpPage.errorsText().contains("The Email field must contain a valid email address."));
    }
}
