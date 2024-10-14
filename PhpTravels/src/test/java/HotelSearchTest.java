import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchTest extends BaseTest{

    @Test
    public void searchHotelTest(){
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
                stream().map(WebElement::getText).collect(Collectors.toList());

        //System.out.println(hotelsName.size());
        //hotelsName.forEach(el -> System.out.println(el));
        hotelsName.forEach(System.out::println);

        Assert.assertEquals(hotelsName.get(0),"Jumeirah Beach Hotel");
        Assert.assertEquals(hotelsName.get(1),"Oasis Beach Tower");
        Assert.assertEquals(hotelsName.get(2),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelsName.get(3),"Hyatt Regency Perth");
            }
    @Test
    public void searchHotelNoResultFindTest(){
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
         }
}
