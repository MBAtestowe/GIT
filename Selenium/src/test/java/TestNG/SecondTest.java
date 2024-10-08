package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class SecondTest extends BaseTest{
    WebDriver driver;

    @Test
    public void firstTest()  {
        driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist2(By.tagName("p"));

        WebElement para = driver.findElement(By.tagName("p"));
        Assert.assertEquals(para.isDisplayed(),true);
        Assert.assertTrue(para.isDisplayed(), "Element jest niewidoczny");
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().startsWith("Pojawiłem"));
        Assert.assertEquals(para.getText(), "Dopiero się pojawiłem!");
        //Assert.assertEquals(para.getText(), "Dopiero", "Teksty są różne"); //dodajemy wiadomość w przypadku faila
        driver.close();
    }
    @Test
    public void secondTest()  {
        driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist2(By.tagName("p"));

        WebElement para = driver.findElement(By.tagName("p"));

        SoftAssert softAsert = new SoftAssert();

        softAsert.assertEquals(para.isDisplayed(),true);
        softAsert.assertTrue(para.isDisplayed(), "Element jest niewidoczny");
        softAsert.assertEquals(para.getText(), "Dopiero", "Pierwszy fail");
        softAsert.assertTrue(para.getText().startsWith("Dopiero"));
        softAsert.assertFalse(para.getText().startsWith("Pojawiłem"));
        softAsert.assertEquals(para.getText(), "Dopiero się pojawiłem!");
        softAsert.assertEquals(para.getText(), "Dopiero się!", "Drugi fail");

        driver.close();
        softAsert.assertAll();
    }
    
    public void waitForElementToExist2(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until(new Function<WebDriver, Object>() {
            @Override
            public Object apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Elementu nie ma na stronie");
                    return false;
                }
            }
        });
    }
}
