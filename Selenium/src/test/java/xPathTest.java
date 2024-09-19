import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class xPathTest {
    @Test
    public void FindElement() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.findElement(By.xpath("//button[@id='clickOnMe']"));
        driver.findElement(By.xpath("//input[@name='fname']"));
        driver.findElement(By.xpath("//p[@class='topSecret']"));
        driver.findElement(By.xpath("//input")).sendKeys("Pierwszy");
        driver.findElements(By.xpath("//input"));
        driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        driver.findElement(By.xpath("//a[contains(text(),'Visit')]"));
        driver.findElement(By.xpath("//*"));
        driver.findElements(By.xpath("(//input)[2]")); //counting starts from 1 not 0!
        driver.findElements(By.xpath("(//input)[last()]"));
        driver.findElement(By.xpath("//*[@name]"));
        driver.findElement(By.xpath("//button[@id]"));
        driver.findElement(By.xpath("//button[@id!='clickOnMe']"));
        driver.findElement(By.xpath("//*[contains(@name,'name')]"));
        driver.findElement(By.xpath("//*[starts-with(@name,'f')]"));

        //driver.findElement(By.xpath("//*[ends-with(@name,'name')]"));
        String text = "username";
        String substring = text.substring(text.length()-4);
        System.out.println(substring);
        driver.findElement(By.xpath("//*[substring(@name,string-length(@name)-string-length('ame')+1)='ame']"));

        driver.findElement(By.xpath("//div/child::ul"));
        driver.findElement(By.xpath("//div//ul"));
        driver.findElement(By.xpath("//div/descendant::ul"));
        driver.findElement(By.xpath("//div/descendant::*"));
        driver.findElement(By.xpath("//div/ancestor::*"));
        driver.findElement(By.xpath("//div/..")); //bezpośredni rodzic
        driver.findElement(By.xpath("//img/following::*"));
        driver.findElement(By.xpath("//img/following-sibling::*"));
        driver.findElement(By.xpath("//img/preceding::*"));
        driver.findElement(By.xpath("//img/preceding-sibling::*"));
        driver.findElement(By.xpath("//a | //input"));
        driver.findElement(By.xpath("//input[@name='fname' and @id='fname']"));
        driver.findElement(By.xpath("//input[@name='fname' or @id='fname']"));
    }
}
