import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {
    @Test
    public void imageTest(){
        WebDriver driver = new EdgeDriver();
        //driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");

        WebElement image = driver.findElement(By.tagName("img"));
        String height = image.getAttribute("naturalHeight");
        Assert.assertEquals(height, "0");
    }
}
