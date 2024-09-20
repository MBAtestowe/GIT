import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {
    @Test
    public void testNewWindow(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");
        driver.findElement(By.linkText("Podstawowa strona testowa")).click();
        //nazwa okna
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        // nazwa nowego okna, przepięcie
        Set<String> windowNames = driver.getWindowHandles();
        for(String window : windowNames){
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//div[text()='Odrzuć wszystko']")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        // powrót do pierwotnego okna
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Babcia");

    }
}
