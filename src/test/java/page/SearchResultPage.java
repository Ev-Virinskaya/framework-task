package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

public class SearchResultPage extends BasePage {
    private Logger logger = LogManager.getRootLogger();

    private final String elementToFindLocator;
    private final static String ELEMENT_COMMON_SEARCH_RESULT_LOCATOR = "//a[@class='gs-title']";
    private final static String PATTERN_LOCATOR = "%s/b[text()='%s']/..";


    public SearchResultPage(WebDriver driver, FluentWait<WebDriver> wait, String request) {
        super(driver, wait);
        this.elementToFindLocator = String.format(PATTERN_LOCATOR, ELEMENT_COMMON_SEARCH_RESULT_LOCATOR, request);
    }

    public CalculatorPage openCalculatorPage() {
        findRelevantResponse().click();

        return new CalculatorPage(driver, wait);
    }

    private WebElement findRelevantResponse() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ELEMENT_COMMON_SEARCH_RESULT_LOCATOR)));
        List<WebElement> relevantResponses = driver.findElements(By.xpath(elementToFindLocator));
//        if (relevantResponses == null || relevantResponses.isEmpty()) {
//            return new HomePageCloud(driver, wait).openPage().searchInfo().findRelevantResponse();
//        } else {}
            return relevantResponses.get(0);

    }
}
