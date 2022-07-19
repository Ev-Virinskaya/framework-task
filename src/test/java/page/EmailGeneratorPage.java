package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class EmailGeneratorPage extends BasePage{
    private Logger logger = LogManager.getRootLogger();
    private static final String ADDRESS_EMAIL_GENERATOR = "https://yopmail.com/";

    private static final String EMAIL_GENERATOR_BUTTON = "//*[@id='listeliens']/a[@href='email-generator']";
    private static final String EMAIL_ADDRESS_FIELD = "//*[@id='egen']";
    private static final String EMAIL_PAGE_BUTTON = "//button[@onclick='egengo();']";

    public EmailGeneratorPage(WebDriver driver, FluentWait<WebDriver> wait) {
        super(driver, wait);
        driver.get(ADDRESS_EMAIL_GENERATOR);
    }

    public String generateEmailAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_GENERATOR_BUTTON))).click();
        String email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAIL_ADDRESS_FIELD))).getText();
        driver = switchToWindow();
        return email;
    }

    public EmailPage openEmailPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAIL_PAGE_BUTTON))).click();
        return new EmailPage(driver, wait);
    }
}
