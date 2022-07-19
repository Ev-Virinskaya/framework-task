package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ResultPage extends BasePage{
    private Logger logger = LogManager.getRootLogger();
    private static final String MAIL_BUTTON = "//button[@id='email_quote']";
    public static final String REGION_LOCATOR = "//div[contains(text(),'Region:')]";
    public static final String VM_CLASS_LOCATOR = "//div[contains(text(),'Provisioning model:')]";
    public static final String INSTANCE_TYPE_LOCATOR = "//div[contains(text(),'Instance type:')]";
    public static final String LOCAL_SSD_LOCATOR = "//div[contains(text(),'Local SSD:')]";
    public static final String COMMITMENT_TERM_LOCATOR = "//div[contains(text(),'Commitment term:')]";
    public static final String ESTIMATE_COST_LOCATOR = "//*[@id='resultBlock']//h2/b";

    public ResultPage(WebDriver driver, FluentWait<WebDriver> wait) {
        super(driver,wait);

    }

    public String getData(String locator){
        return wait.pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
    }

    public String getRegionData(){
        return getData(REGION_LOCATOR);
    }
    public String getVmClassData(){
        return getData(VM_CLASS_LOCATOR);
    }
    public String getInstanceTypeData(){
        return getData(INSTANCE_TYPE_LOCATOR);
    }
    public String getLocalSsdData(){
        return getData(LOCAL_SSD_LOCATOR);
    }
    public String getCommitmentTermData(){
        return getData(COMMITMENT_TERM_LOCATOR);
    }
    public String getEstimateCostData(){
        return getData(ESTIMATE_COST_LOCATOR);
    }


    public EmailForm getEmailForm (){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MAIL_BUTTON))).click();
        return new EmailForm(driver,wait);
    }

}
