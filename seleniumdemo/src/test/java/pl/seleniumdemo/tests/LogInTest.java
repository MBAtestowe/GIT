package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest() {
        WebElement dasboardLink = new HomePage(driver)
                .openMyAccount()
                .logInValidData("test222@test.pl", "test222@test.pl")
                .getDashboardLink();

        Assert.assertEquals(dasboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInInvalidDataTest() {
        WebElement error = new HomePage(driver)
                .openMyAccount()
                .logInInvalidData("test227@test.pl", "test222@test.pl")
                .getError();

        Assert.assertTrue(error.getText().contains("Incorrect username"));
    }
}
