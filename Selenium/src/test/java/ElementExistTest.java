import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class ElementExistTest {
    WebDriver driver;
    @Test
    public void elementExistTest (){
      driver = new EdgeDriver();
      driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
      // pierwsza metoda try-catch, czy istnieje
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        //druga metoda czy istnieje
        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.id("topSecret")));

        //czy element jest widoczny
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        //czy można wejść w interakcję z elementem
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        //czy checbox jest zaznaczony
        System.out.println(driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected());
    }
    public boolean elementExist(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean elementExistSecond (By locator){
        return driver.findElements(locator).size()>0;
    }
}
