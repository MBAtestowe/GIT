package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HotelSearchPage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement HotelSearchSpan;
    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement HotelSearchInput;
    @FindBy(name = "checkin")
    private WebElement CheckInInput;
    @FindBy(name = "checkout")
    private WebElement CheckOutInput;
    @FindBy(id = "travellersInput")
    private WebElement travelersInput;
    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlsBtn;
    @FindBy(id = "childPlusBtn")
    private WebElement childPlsBtn;
    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;
    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> myAccountButton;
    @FindBy(xpath = "//a[text()='  Sign Up']")
    private List<WebElement> signUpButton;

    private WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HotelSearchPage setCity(String cityName) {
        HotelSearchSpan.click();
        HotelSearchInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public HotelSearchPage setDates(String checkin, String checkout) {
        CheckInInput.sendKeys(checkin);
        CheckOutInput.sendKeys(checkout);
        return this;
    }

    public HotelSearchPage setTravelers(int adultsToAdd, int childToAdd) {
        travelersInput.click();
        addTraveler(adultPlsBtn, adultsToAdd);
        addTraveler(childPlsBtn, childToAdd);
        return this;
    }

    private void addTraveler(WebElement travelerBtn, int numberOfTravelers) {
        for (int i = 0; i < numberOfTravelers; i++) {
            travelerBtn.click();
        }
    }

    public ResultsPage performSearch() {
        searchButton.click();
        return new ResultsPage(driver);
    }

    public SignUpPage signUpForm() {
        myAccountButton.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        signUpButton.get(1).click();
        return new SignUpPage(driver);
    }
}
