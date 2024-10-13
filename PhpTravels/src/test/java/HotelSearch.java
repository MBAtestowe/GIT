import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelSearch {

    @Test
    public void searchHotel(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();
        driver.findElement(By.name("checkin")).sendKeys("12/10/2024");
        driver.findElement(By.name("checkout")).sendKeys("18/10/2024");
       driver.findElement(By.name("checkout")).click();
        /*driver.findElements(By.xpath("//td[@class='day ' and text()='18']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);*/
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultMinusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        List<String> hotelsName = driver.findElements(By.xpath("//h4[contains(@class, 'list_title')]//b")).
                stream().map(el -> el.getAttribute("textContent")).collect(Collectors.toList());

        //System.out.println(hotelsName.size());
        //hotelsName.forEach(el -> System.out.println(el));
        hotelsName.forEach(System.out::println);

        Assert.assertEquals(hotelsName.get(0),"Jumeirah Beach Hotel");
        Assert.assertEquals(hotelsName.get(1),"Oasis Beach Tower");
        Assert.assertEquals(hotelsName.get(2),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelsName.get(3),"Hyatt Regency Perth");
    }
    @Test
    public void searchHotelNoResultFind(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.findElement(By.name("checkin")).sendKeys("10/10/2024");
        driver.findElement(By.name("checkout")).click();
        driver.findElements(By.xpath("//td[@class='day ' and text()='20']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultMinusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();
        WebElement heading = driver.findElement(By.xpath("//div[@class='itemscontainer']//h2"));

        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(), "No Results Found");
        driver.quit();


    }
}
