package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.seleniumdemo.utils.SeleniumHelper;

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
    private static final Logger logger = LogManager.getLogger();

    public HotelSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HotelSearchPage setCity(String cityName) {
        logger.info("Setting city " + cityName);
        HotelSearchSpan.click();
        HotelSearchInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        SeleniumHelper.waitForElementToExist(driver,By.xpath(xpath));
        driver.findElement(By.xpath(xpath)).click();
        logger.info("Setting city done");
        return this;
    }

    public HotelSearchPage setDates(String checkin, String checkout) {
        logger.info("Setting date check-in:"+ checkin+", checkout:"+checkout);
        CheckInInput.sendKeys(checkin);
        CheckOutInput.sendKeys(checkout);
        logger.info("Setting dates done");
        return this;
    }

    public HotelSearchPage setTravelers(int adultsToAdd, int childToAdd) {
        logger.info("Adding number of adults:"+adultsToAdd+", and children:" +childToAdd);
        travelersInput.click();
        addTraveler(adultPlsBtn, adultsToAdd);
        addTraveler(childPlsBtn, childToAdd);
        logger.info("Setting number of travellers done");
        return this;
    }

    private void addTraveler(WebElement travelerBtn, int numberOfTravelers) {
        for (int i = 0; i < numberOfTravelers; i++) {
            travelerBtn.click();
        }
    }

    public ResultsPage performSearch() {
        logger.info("Performing search");
        searchButton.click();
       logger.info("Performing search done");
        return new ResultsPage(driver);
    }

    public SignUpPage signUpForm() {
        myAccountButton.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        signUpButton.get(1).click();
        return new SignUpPage(driver);
    }
}
