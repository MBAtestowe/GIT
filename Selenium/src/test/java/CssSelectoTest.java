import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CssSelectoTest {
    @Test
    public void FindElement(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //driver.findElement(By.cssSelector("#clickOnMe")).click();
        driver.findElement(By.cssSelector(".topSecret"));
        driver.findElement(By.cssSelector("input"));
        driver.findElement(By.cssSelector("[name='fname']"));
    }
}
