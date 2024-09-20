import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionTest {
    @Test
    public void BasicAction() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");
        // click()
        driver.findElement(By.linkText("Podstawowa strona testowa")).click();
        //sendKeys()
        driver.findElement(By.id("fname")).sendKeys("1234");
        WebElement username = driver.findElement(By.name("username"));
        //clear()
        username.clear();
        username.sendKeys("admin");
        //sendKeys enum
        username.sendKeys(Keys.TAB);
        //getAttribute - na input, na reszcie WebElement getText()
        System.out.println(username.getText());  // na input to nie zadziałą
        System.out.println(username.getAttribute("value"));
        username.sendKeys(Keys.ENTER);
        //alert, rodzaje: https://www.w3schools.com/js/js_popup.asp
        Alert firstAlert= driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept(); // drugi alert na stronie
        //firstAlert.dismiss();
        //firstAlert.sendKeys("abc");
        //firstAlert.getText();

        // checkbox, radiobutton
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@value='female']")).click();
        // klasa select
        WebElement select = driver.findElement(By.xpath("//select"));
        Select cars = new Select(select);
        //cars.selectByIndex(2); //numerujemy od 0
        //cars.selectByValue("volvo");
        cars.selectByVisibleText("Saab");
        List<WebElement> options = cars.getOptions();
        for (WebElement option : options){
            System.out.println(option.getText());
        }
        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.selectCheck("Volvo", select));

        //pobieranie wartości z ukrytego elementu
        WebElement paragraph = driver.findElement(By.className("topSecret"));
        System.out.println( "By getText:" +paragraph.getText());
        System.out.println("By getAttribute: " +paragraph.getAttribute("value"));
        System.out.println("By textContent: " +paragraph.getAttribute("textContent"));
    }
}
