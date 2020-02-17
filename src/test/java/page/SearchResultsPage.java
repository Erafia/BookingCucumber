package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SearchResultsPage extends BasePage {
    String nameLocator = "//span[contains(text(), '%s')]";
    String ratingLocator = "//span[contains(text(), '%s')]/../../../../..//div[@class='bui-review-score__badge']";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void checkHotelIsDisplayed(String hotelName){
        List<WebElement> hotels = driver.findElements(By.xpath(String.format(nameLocator, hotelName)));
        assertEquals(hotels.size(), 1, "Отель не появился в результатах поиска");
    }

    public void checkHotelRating(String hotelName, String rating){
        WebElement hotelsRating = driver.findElement(By.xpath(String.format(ratingLocator, hotelName)));
        assertEquals(hotelsRating.getText(),rating, "Отель рейтинга не совпадает: ожидался " + rating + ", вместо этого рейтинг равен " + hotelsRating.getText());
    }
}
