import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {
    @Test

    public void uploadFile() throws IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        int randomNumber = (int) (Math.random()*1000);
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Gosia\\Downloads\\sample.txt");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "screenshot" + randomNumber + ".png";
        FileUtils.copyFile(srcFile, new File("src/test/resources/" + fileName));

        //kliknięcie prawym przyciskiem myszy
        Actions action = new Actions(driver);
        //action.contextClick().perform();  //dowolne miejsce na stronie
        action.contextClick(driver.findElement(By.id("myFile"))).perform();
    }
}
