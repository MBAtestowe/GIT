package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.seleniumdemo.model.User;
import pl.seleniumdemo.utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpPage {

    @FindBy(name = "firstname")
    private WebElement firstNameInput;
    @FindBy(name = "lastname")
    private WebElement lastNameInput;
    @FindBy(name = "phone")
    private WebElement phoneInput;
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[text()=' Sign Up']")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private List<WebElement> errors;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement emailAlreadyExistsError;
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignUpPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public SignUpPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public SignUpPage setPhoneName(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public SignUpPage setEmailName(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public SignUpPage setPasswordName(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public SignUpPage confirmPasswordName(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }

    public LoggedUserPage signUp() {
        signUpButton.click();
        return new LoggedUserPage(driver);
    }

    public List<String> errorsText() {
        SeleniumHelper.waitForNotEmptyList(driver, By.xpath("//div[@class='alert alert-danger']//p"));
                return errors.stream().map(el -> el.getAttribute("textContent")).collect(Collectors.toList());
    }

    public String emailAlreadyExists() {
        SeleniumHelper.waitForNotEmptyList(driver, By.xpath("//div[@class='alert alert-danger']"));
        return emailAlreadyExistsError.getText();
    }

    public void fillSignUpForm(String firstName, String lastName, String phone, String email, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneInput.sendKeys(phone);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        signUpButton.click();
    }

    public void fillSignUpForm(User user) {
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        phoneInput.sendKeys(user.getPhone());
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        confirmPasswordInput.sendKeys(user.getPassword());
        signUpButton.click();
    }
}
