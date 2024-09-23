import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    @Test

    public void actionsTest() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        //kliknięcie prawym przyciskiem myszy
        Actions action = new Actions(driver);
        //action.contextClick().perform();  //dowolne miejsce na stronie
        action.contextClick(driver.findElement(By.id("myFile"))).perform();
        driver.quit();
    }

        @Test
        public void doubleCLickTest(){
        WebDriver driver2 = new EdgeDriver();
        driver2.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        //podwójne kliknięcie
        Actions action2 = new Actions(driver2);
        //action2.doubleClick().perform();
        action2.doubleClick(driver2.findElement(By.id("bottom"))).perform();
    }
        @Test
        public void hoverTest(){
        WebDriver driver3 = new EdgeDriver();
        driver3.get("https://testeroprogramowania.github.io/selenium/basics.html");
        Actions actions3 = new Actions(driver3);
        actions3.moveToElement(driver3.findElement(By.tagName("h1"))).perform();
    }
}
