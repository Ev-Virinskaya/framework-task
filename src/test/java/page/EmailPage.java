package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;

public class EmailPage extends BasePage{
    private Logger logger = LogManager.getRootLogger();
    private static final String FULL_IFRAME_EMAIL = "//iframe[@id='ifmail' and @state='full']";
    private static final String ESTIMATE_COST = "//td[@colspan='3']/following-sibling::td/h3";

    private static final String REFRESH_BUTTON = "//*[@id='refresh']";
    private static final String FULL_IFRAME_MAILBOX = "//iframe[@id='ifinbox' and @state='full']";
    private static final String CURRENT_MAIL = "//button[@class='lm' and @onclick='g(this);']";

    private static int counter = 0;

    public EmailPage(WebDriver driver, FluentWait<WebDriver> wait) {
        super(driver, wait);
    }

    private void refreshEmailBox() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REFRESH_BUTTON))).click();
    }

    private void findAndOpenEmailInBox() {

        if (counter >= 5) {
            throw new NoSuchElementException();
        }
        try {
            switchToIframeWithTimeout(FULL_IFRAME_MAILBOX);
            System.out.println(driver.findElement(By.xpath(CURRENT_MAIL)).getText());
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CURRENT_MAIL))).click();
            driver.switchTo().parentFrame();
        } catch (Throwable e) {
            refreshEmailBox();
            counter++;
            findAndOpenEmailInBox();
        }
    }

    public String getEstimateCost() {
        findAndOpenEmailInBox();
        switchToIframeWithTimeout(FULL_IFRAME_EMAIL);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ESTIMATE_COST))).getText();
    }
}
