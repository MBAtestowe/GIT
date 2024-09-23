import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ExecutorTest {
    @Test

    public void executeJavascript(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");
        WebElement basicPage= driver.findElement(By.linkText("Podstawowa strona testowa"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",basicPage);
        WebElement firstName = driver.findElement(By.name("fname"));
        executor.executeScript("arguments[0].setAttribute('value','babuszka');",firstName);


    }
}
