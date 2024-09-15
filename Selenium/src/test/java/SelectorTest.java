import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {
    @Test
    public void findElements(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.name("fname")).sendKeys("abc");
        driver.findElement(By.className("topSecret"));
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.size());
        //driver.findElement(By.linkText("Visit W3Schools.com!")).click();
        driver.findElement(By.partialLinkText("Weird")).click();
    }
}
