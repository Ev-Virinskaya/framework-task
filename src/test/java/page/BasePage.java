package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.Set;

public abstract class BasePage {
    WebDriver driver;
    FluentWait<WebDriver> wait;


    public BasePage(WebDriver driver, FluentWait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public FluentWait<WebDriver> getWait() {
        return wait;
    }

    public WebDriver switchToWindow() {
        String currentWindow;
        String windowToSwitch = null;
        currentWindow = driver.getWindowHandle();
        Set<String> currentWindows = driver.getWindowHandles();
        for (String window : currentWindows) {
            if (!window.equals(currentWindow)) {
                windowToSwitch = window;
                break;
            }
        }
        return driver.switchTo().window(windowToSwitch);
    }

    public WebDriver openNewWindow() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open()");
        return switchToWindow();
    }
    public WebDriver switchToSecondIframe(String iframeFirstLevelLocator, String iframeSecondLevelLocator){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iframeFirstLevelLocator)));
        switchToIframeWithTimeout(iframeFirstLevelLocator);
        return switchToIframeWithTimeout(iframeSecondLevelLocator);
    }

    public WebDriver switchToIframeWithTimeout(String iframeLocator){
        return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(iframeLocator)));
    }
}
