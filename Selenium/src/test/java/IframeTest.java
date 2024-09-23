import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class IframeTest {
    @Test
    public void iframeTest (){
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        driver.switchTo().frame(0); //numerujemy od 0
        driver.findElement(By.id("fname")).sendKeys("babcia");
        driver.switchTo().defaultContent();  //powrót do głównej strony
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        WebElement iframe = driver.findElement(By.xpath("//*[@src='basics.html']"));
        driver.switchTo().frame(iframe); //2 metoda Webelement
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().defaultContent();
        //driver.switchTo().frame("wartość id lun name"); //3 metoda, w tym przypadku iframe ich nie posiada


    }
}
