package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingSearchPage extends BasePage {
    By SEARCH_FIELD = By.id("ss");
    By SEARCH_BUTTON = By.xpath("//button[@data-sb-id= 'main']");
    By SEARCH_FORM = By.id("frm");
    String URL = "https://www.booking.com/";


    public BookingSearchPage(WebDriver driver) {
        super(driver);
        driver.manage().window().maximize();
        driver.get(URL);
        isPageOpened(driver);
    }

    public void isPageOpened(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD));
        } catch (NoSuchElementException e) {
            System.out.println("Главная страница не открыта");
        }
    }

    public void searchForHotel(String hotelName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            driver.findElement(SEARCH_FIELD).clear();
            driver.findElement(SEARCH_FIELD).sendKeys(hotelName);
            driver.findElement(SEARCH_BUTTON).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FORM));
        } catch (Exception e) {
            System.out.println("Невозможно начать поиск отеля");
        }
    }

}
