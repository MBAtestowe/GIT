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
        driver.findElement(By.cssSelector("*")); //all
        driver.findElement(By.cssSelector("div ul"));
        driver.findElement(By.cssSelector("table tr"));
        driver.findElement(By.cssSelector("tbody tr"));
        driver.findElement(By.cssSelector("div > ul")); //firstchild
        driver.findElement(By.cssSelector("tbody > tr"));
        driver.findElement(By.cssSelector("label + form")); //followingsibling
        driver.findElement(By.cssSelector("label ~ form")); //allfollowingsiblings

        driver.findElement(By.cssSelector("[name*='name']"));  //contains name
        driver.findElement(By.cssSelector("[name^='user']"));  //starting from user
        driver.findElement(By.cssSelector("[name$='name']"));  // ending at name

        driver.findElement(By.cssSelector("li:first-child"));
        driver.findElement(By.cssSelector("li:last-child"));
        driver.findElement(By.cssSelector("li:nth-child(2)"));  //counting starts from 1 not 0!
    }
}
