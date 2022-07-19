package test;

import driver.DriverSingleton;
import model.Request;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import page.HomePageCloud;
import page.ResultPage;
import service.RequestCreator;
import util.TestListener;


@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;
    protected ResultPage resultPage;
    protected Request request;

    @BeforeClass
    public void setupBrowser() {
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, 15);
        request = RequestCreator.withRegDataFromProperty();
        resultPage = new HomePageCloud(driver, wait)
                .openPage()
                .searchInfo(request)
                .openCalculatorPage()
                .switchCalcForm()
                .fillFields(request);
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}