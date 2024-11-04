package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage {
    @FindBy(xpath = "//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> hotelLists;
    @FindBy(xpath = "//div[@class='itemscontainer']//h2")
    public WebElement resultsHeading;

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getHotelsName() {
        return hotelLists.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getHeadingTitle() {
        return resultsHeading.getText();
    }
}

