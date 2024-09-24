package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        String para = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(para, "Dopiero się pojawiłem!");
        driver.close();
    }
    @Test
    public void secondTest()  {
        driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist2(By.tagName("p"));

        String para = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(para, "Dopiero się pojawiłem!");
        driver.close();
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
