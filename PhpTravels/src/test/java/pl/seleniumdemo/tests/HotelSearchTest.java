package pl.seleniumdemo.tests;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;
import pl.seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;
import java.util.List;

public class HotelSearchTest extends BaseTest {

    @Test
    public void searchHotelTest() throws IOException {
        ExtentTest test = extentReports.createTest("Search Hotel Test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        List<String> hotelNames = hotelSearchPage
                .setCity("Dubai")
                .setDates("14/10/2024", "20/10/2024")
                .setTravelers(1, 2)
                .performSearch().getHotelsName();
        test.log(Status.PASS,"Setting city done");
        test.log(Status.PASS,"Setting dates done");
        test.log(Status.PASS,"Setting travelers done");
        test.log(Status.PASS,"Performing search done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Screenshot", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
        test.log(Status.PASS,"Assertion passed",SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void searchHotelNoResultFindTest() {
        ResultsPage resultsPage = new HotelSearchPage(driver)
                .setDates("14/10/2024", "20/10/2024")
                .setTravelers(0, 1)
                .performSearch();

        Assert.assertTrue(resultsPage.resultsHeading.isDisplayed());
        Assert.assertEquals(resultsPage.getHeadingTitle(), "No Results Found");
    }
}
