package pl.seleniumdemo.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;

import java.util.List;

public class HotelSearchTest extends BaseTest {

    @Test
    public void searchHotelTest() {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        List<String> hotelNames = hotelSearchPage
                .setCity("Dubai")
                .setDates("14/10/2024", "20/10/2024")
                .setTravelers(1, 2)
                .performSearch().getHotelsName();

        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
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
