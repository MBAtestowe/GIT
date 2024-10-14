import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SignUpTest extends BaseTest{

    @Test
    public void signUpTest(){

        String lastName = "Nowak";
        int randomNumber = (int) (Math.random()*1000);
        String email = "anna" + randomNumber + "@gmail.com";
        driver.findElements(By.xpath("//li[@id='li_myaccount']"))
                .stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys("Anna");
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys("8598561239");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("Anowak123");
        driver.findElement(By.name("confirmpassword")).sendKeys("Anowak123");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));
        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(), "Hi, Anna Nowak");
    }
    @Test
    public void emailAlreadyExistsTest(){
        driver.findElements(By.xpath("//li[@id='li_myaccount']"))
                .stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys("Anna");
        driver.findElement(By.name("lastname")).sendKeys("Nowak");
        driver.findElement(By.name("phone")).sendKeys("8598561239");
        driver.findElement(By.name("email")).sendKeys("anowak@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Anowak123");
        driver.findElement(By.name("confirmpassword")).sendKeys("Anowak123");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
        WebElement warning =driver.findElement(By.xpath("//div[text()=' Email Already Exists. ']"));

        Assert.assertTrue(warning.isDisplayed());
        Assert.assertEquals(warning.getText(), "Email Already Exists.");
    }
    @Test
    public void emptyFormTest(){
        driver.findElements(By.xpath("//li[@id='li_myaccount']"))
                .stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p"))
                .stream().map(el-> el.getAttribute("textContent")).collect(Collectors.toList());

        /*Assert.assertEquals(errors.get(0),"The Email field is required.");
        Assert.assertEquals(errors.get(1),"The Password field is required.");
        Assert.assertEquals(errors.get(2),"The Password field is required.");
        Assert.assertEquals(errors.get(3),"The First name field is required.");
        Assert.assertEquals(errors.get(4),"The Last Name field is required.");*/

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();
    }
    @Test
    public void unvalidEmailTest(){
        driver.findElements(By.xpath("//li[@id='li_myaccount']"))
                .stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys("Anna");
        driver.findElement(By.name("lastname")).sendKeys("Nowak");
        driver.findElement(By.name("phone")).sendKeys("8598561239");
        driver.findElement(By.name("email")).sendKeys("anowakgmail.com");
        driver.findElement(By.name("password")).sendKeys("Anowak123");
        driver.findElement(By.name("confirmpassword")).sendKeys("Anowak123");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p"))
                .stream().map(el-> el.getAttribute("textContent")).collect(Collectors.toList());


        Assert.assertTrue(errors.contains("The Email field must contain a valid email address."));
    }
}
