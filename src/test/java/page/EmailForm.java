package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class EmailForm extends BasePage{
    private Logger logger = LogManager.getRootLogger();
    private static final String IFRAME_FIRST_LEVEL_LOCATOR = "//iframe[contains(@name,'goog_')]";
    private static final String IFRAME_SECOND_LEVEL_LOCATOR = "//*[@id='myFrame']";

    private static final String EMAIL_INPUT_LOCATOR = "//input[@type='email']";
    private static final String EMAIL_BUTTON_LOCATOR = "//button[@aria-label='Send Email']";

    private EmailGeneratorPage emailGeneratorPage;

    public EmailForm(WebDriver driver, FluentWait<WebDriver> wait) {
        super(driver, wait);
    }

    private String createEmail(){
        driver = openNewWindow();
        emailGeneratorPage = new EmailGeneratorPage(driver,wait);
        return emailGeneratorPage.generateEmailAddress();
    }


    public EmailGeneratorPage sendEmail(){
        String email = createEmail();
        switchToSecondIframe(IFRAME_FIRST_LEVEL_LOCATOR,IFRAME_SECOND_LEVEL_LOCATOR);
        wait.until(ExpectedConditions.attributeToBe(By.xpath(EMAIL_INPUT_LOCATOR),"isConnected", "true"));
        driver.findElement(By.xpath(EMAIL_INPUT_LOCATOR)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_BUTTON_LOCATOR))).click();
        switchToWindow();
        return emailGeneratorPage;
    }
}
