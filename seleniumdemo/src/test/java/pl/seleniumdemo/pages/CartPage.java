package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proceededToCheckoutButton;
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public AddressDetailsPage openAddressDetails (){
        proceededToCheckoutButton.click();
        return new AddressDetailsPage(driver);

    }
}
