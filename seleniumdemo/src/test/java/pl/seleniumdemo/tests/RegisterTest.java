package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;

public class RegisterTest extends BaseTest {
    @Test
    public void registerUserTest() {
        int randomNumber = (int) (Math.random()*1000);

        WebElement dasboardLink = new HomePage(driver).openMyAccount()
                .register("test" + randomNumber+ "@test.pl", "test222@test.pl").getDashboardLink();

        Assert.assertEquals(dasboardLink.getText(), "Dashboard");
    }
    @Test
    public void registerUserWithSameEmailTest() {
               WebElement error = new HomePage(driver).openMyAccount()
                .register("test222@test.pl", "test222@test.pl").getError();

        Assert.assertTrue(error.getText().contains("already registered"));
    }
}
