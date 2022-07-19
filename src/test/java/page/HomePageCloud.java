package page;

import model.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePageCloud extends BasePage{
    private Logger logger = LogManager.getRootLogger();
    private static final String HOME_PAGE = "https://cloud.google.com";
    private static final String SEARCH_INPUT = "//input[@name='q']";



    public HomePageCloud(WebDriver driver, FluentWait<WebDriver> wait) {

        super(driver, wait);

    }

    public HomePageCloud openPage() {
        driver.get(HOME_PAGE);
        return this;
    }

    public SearchResultPage searchInfo(Request request) {
        String searchRequest = request.getSearchRequest();
        WebElement element = driver.findElement(By.xpath(SEARCH_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        element.sendKeys(searchRequest, Keys.ENTER);
        return new SearchResultPage(driver, wait, searchRequest);
    }

}
