package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class CalculatorPage extends BasePage{
    private Logger logger = LogManager.getRootLogger();
    private static final String IFRAME_FIRST_LEVEL_LOCATOR = "//iframe[contains(@name,'goog_')]";
    private static final String IFRAME_SECOND_LEVEL_LOCATOR = "//*[@id='myFrame']";

    public CalculatorPage(WebDriver driver, FluentWait<WebDriver> wait) {
        super(driver, wait);
        this.driver = driver;
    }

    public CalculatorForm switchCalcForm(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(IFRAME_FIRST_LEVEL_LOCATOR)));
        switchToSecondIframe(IFRAME_FIRST_LEVEL_LOCATOR, IFRAME_SECOND_LEVEL_LOCATOR);
        return new CalculatorForm(driver, wait);
    }
}
