package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FourthTest {
    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest(){
        System.out.println("I am first test.");
    }
    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest(){
        System.out.println("I am second test.");
    }
    @Test
    public void thirdTest(){
        System.out.println("I am third test.");
    }

    @Test(dataProvider = "data")
    public void dpTest( String value, String number){
        System.out.println(number);
        System.out.println(value);
    }

    @DataProvider (name = "data")
    public  Object[][] dataProvider(){
        return new Object[][] {{"I am first test", "First"}, {"I am second test", "Second"}, {"I am third test", "Third"}};
    }

}
