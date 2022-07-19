package page;

import model.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CalculatorForm extends BasePage {
    private Logger logger = LogManager.getRootLogger();

    private static final String PATTERN_CHOICE_PARAM_LOCATOR = "//md-option%s/div[contains(text(),'%s')]";
    private static final String NUMBER_OF_GPU_CHOICE_PART_LOCATOR = "[contains(@ng-disabled,'GPU')]";
    private static final String REGION_CHOICE_PART_LOCATOR = "[@id='select_option_222']";
    private static final String USAGE_CHOICE_PART_LOCATOR = "[@id='select_option_124']";


    public CalculatorForm(WebDriver driver, FluentWait<WebDriver> wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;
    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input[@name='quantity']")
    private WebElement input;
    @FindBy(xpath = "//label[text()='Operating System / Software']/following-sibling::*/md-select-value")
    private WebElement softwareField;
    @FindBy(xpath = "//label[text()='Provisioning model']/following-sibling::*/md-select-value")
    private WebElement VMClassField;
    @FindBy(xpath = "//label[text()='Series']/following-sibling::*/md-select-value")
    private WebElement seriesField;
    @FindBy(xpath = "//label[text()='Machine type']/following-sibling::*/md-select-value")
    private WebElement instanceType;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[@aria-label='Add GPUs']")
    private WebElement addGPUCheckbox;
    @FindBy(xpath = "//md-select[@aria-label='GPU type']")
    private WebElement GPUTypeField;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUField;
    @FindBy(xpath = "//label[text()='Local SSD']/following-sibling::*/md-select-value")
    private WebElement localSSDField;
    @FindBy(xpath = "//label[text()='Datacenter location']/following-sibling::*/md-select-value")
    private WebElement regionField;
    @FindBy(xpath = "//label[text()='Committed usage']/following-sibling::*/md-select-value")
    private WebElement usageField;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement addEstimateButton;


    public ResultPage fillFields(Request request) {
        computeEngine.click();
        input.sendKeys(request.getNumberOfInstance());
        fillField(softwareField,request, request.getOsType());
        fillField(VMClassField, request, request.getVmClass());
        fillField(seriesField, request,request.getSeries());
        fillField(instanceType,request, request.getInstanceType());
        addGPUCheckbox.click();
        fillField(GPUTypeField,request, request.getGpuType());
        fillField(numberOfGPUField,request, request.getGpuNumber());
        fillField(localSSDField,request, request.getLocalSsd());
        fillField(regionField,request, request.getRegion());
        fillField(usageField,request, request.getCommitmentTerm());
        addEstimateButton.click();

        return new ResultPage(driver, wait);
    }

    private String buildLocator(Request request, String regData) {
        String firstStringVariable = "";
        if (regData.equals(request.getRegion())) {
            firstStringVariable = REGION_CHOICE_PART_LOCATOR;
        }else if(regData.equals(request.getGpuNumber())){
            firstStringVariable = NUMBER_OF_GPU_CHOICE_PART_LOCATOR;
        }else if (regData.equals(request.getCommitmentTerm())){
            firstStringVariable = USAGE_CHOICE_PART_LOCATOR;
        }
        return String.format(PATTERN_CHOICE_PARAM_LOCATOR, firstStringVariable, regData);
    }


    private void fillField(WebElement field, Request request, String regData) {
        wait.until(ExpectedConditions.elementToBeClickable(field)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(buildLocator(request, regData)))))
                .click();
    }


}
