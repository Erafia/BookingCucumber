package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import page.BookingSearchPage;
import page.SearchResultsPage;


public class BookingSearchSteps {
    BookingSearchPage searchPage;
    SearchResultsPage searchResultsPage;
    WebDriver driver;
    String hotelName;

    @BeforeMethod
    public void setPreliminarySettings() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
    }

    @Given("User is on the search page")
    public void navigateToSearchPage() {
        driver = new ChromeDriver();
        searchPage = new BookingSearchPage(driver);
    }

    @And("Hotel`s name is {string}")
    public void searchHotel(String hotelName) {
        this.hotelName = hotelName;
    }

    @When("User searches for the hotel")
    public void iDoSearch() {
        searchPage.searchForHotel(hotelName);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Then("Hotel {string} is displayed on the page")
    public void resultsPageShouldContain(String hotelName) {
        searchResultsPage.checkHotelIsDisplayed(hotelName);
    }

    @io.cucumber.java.en.And("Hotel {string} has rating {string}")
    public void ratingShouldBe(String hotelName, String rating) {
        searchResultsPage.checkHotelRating(hotelName, rating);
        driver.close();
    }
}
