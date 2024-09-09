import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumTest {

     @Test
     public void openFacebookPage() {
      WebDriver driver= getDriver("edge");
      driver.manage().window().maximize();
      Dimension windowSize = new Dimension(200,200);
      driver.manage().window().setSize(windowSize);
      driver.get("https://www.facebook.com/");
      ((JavascriptExecutor)driver).executeScript("window.open('https://www.facebook.com/','blank','height=300,width=300')");
      //driver.close();
      // close zamknie tylko pierwsze okno, quit oba
      driver.quit();
     }
     @Test
     public void openGooglePage(){
     WebDriver driver= getDriver("edge");
     driver.manage().window().maximize();
     driver.get("https://www.google.com");
     driver.findElement(By.xpath("//div[text()='Odrzuć wszystko']")).click();
     driver.findElement(By.name("q")).sendKeys("Selenium");
     driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
     WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));
     Assert.assertTrue(result.isDisplayed());
     driver.close();
     }
    @Test
    public void anotherPage (){
         WebDriver driver = getDriver("edge");
         driver.manage().window().maximize();
         driver.get("http://seleniumdemo.com/");
         driver.findElement(By.xpath("//span[text()='Shop']")).click();
         WebElement result2 = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));
        Assert.assertTrue(result2.isDisplayed());
        driver.quit();
    }

     public WebDriver getDriver(String browser) {
         switch (browser){
             case "chrome":
                 return new ChromeDriver();
             case "firefox":
                 return new FirefoxDriver();
             case "edge":
                 return new EdgeDriver();
             default: throw new IllegalArgumentException("Invalid browser name");
         }
     }
 }