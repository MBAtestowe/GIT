package TestNG;

import org.testng.annotations.Test;

public class ThirdTest{
    @Test(priority = 2) //będzie 3
    public void firstTest(){
        System.out.println("I am first test.");
    }
    @Test(priority = 0)  //bazowe, będzie 1
    public void secondTest(){
        System.out.println("I am second test.");
    }

    @Test(priority = 1) //będzie 2
    public void thirdTest(){
        System.out.println("I am third test.");
    }


}
