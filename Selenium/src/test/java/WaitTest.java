import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTest {
    WebDriver driver;

    @Test
    public void waitTest() throws InterruptedException {
       driver = new EdgeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //przez 10 sek będzie sprawdzał czy element się pojawił
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        //Thread.sleep(5000); //najgorsza metoda, testy są wstrzymane na 5 sek, trzeba zająć się wyjątkami

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // domyślnie ignoruje Exception
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));

        FluentWait<WebDriver> wait = new FluentWait<>(driver); // domyślnie nie ignoruje Exception
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));  // sprawdza przez 10 sekund
        wait.pollingEvery(Duration.ofSeconds(1)); //sprawdza co sekundę
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("p")))); //wyskoczy błąd, bo paragraf pokuzje się w strukturze dopiero po załadowaniu
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));  //wyszukanie dzieje się w wait, sprawdza widoczność
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));  //sprawdzi czy element istnieje w strukturze

        // driver.findElement(By.tagName("p"));

        waitForElementToExist2(By.tagName("p"));
    }

    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Elementu nie ma na stronie");
                return false;
            }
        });
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
