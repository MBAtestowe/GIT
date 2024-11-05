import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class AnnotationsTest {
    @FindBys({
            @FindBy(tagName ="table"),
            @FindBy(tagName = "th")
    })
    List<WebElement> elements; //szuka tagu th w table, stąd wynik 2
    @FindAll({
            @FindBy(tagName ="table"),
            @FindBy(tagName = "th")
    })
    List<WebElement> elements1; //szuka wszystkich rzeczy, stąd wynik 3

    @Test
    public void BasicAction() {
        WebDriver driver = new EdgeDriver();
        PageFactory.initElements(driver,this);
        driver.get("https://testeroprogramowania.github.io/selenium");
        driver.findElement(By.linkText("Podstawowa strona testowa")).click();
        System.out.println(elements.size());
        System.out.println(elements1.size());
    }
}
