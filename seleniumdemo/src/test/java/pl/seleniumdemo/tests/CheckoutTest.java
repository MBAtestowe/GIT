package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.models.Customer;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkoutTest() {
    Customer customer = new Customer();
    customer.setEmail("specificemail@gmail.com");

    OrderDetailsPage orderDetailsPage= new HomePage(driver)
            .openShopPage()
            .openProduct("Java Selenium WebDriver")
            .addProductToCart()
            .viewCart()
            .openAddressDetails()
            .fillAddressDetails(customer, "Some random comment");
        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(),"Java Selenium WebDriver × 1");
    }


}
