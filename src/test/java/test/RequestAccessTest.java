package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestAccessTest extends BaseTest{
    //VM Class, Instance type, Region, local SSD, commitment term
    @Test
    public void shouldCreateInstanceWithVMClassContainsRegistrationData(){
        String regDataVMClass = request.getVmClass();
        String actualVMClass = resultPage.getVmClassData();
        Assert.assertTrue(actualVMClass.contains(regDataVMClass));
    }
    @Test
    public void shouldCreateInstanceWithTypeContainsRegistrationData(){
        String regDataInstanceType = request.getInstanceType();
        String actualInstanceType = resultPage.getInstanceTypeData();
        Assert.assertTrue(actualInstanceType.contains(regDataInstanceType));
    }
    @Test
    public void shouldCreateInstanceWithRegionContainsRegistrationData(){
        String regDataRegion = request.getRegion();
        String actualRegion = resultPage.getRegionData();
        Assert.assertTrue(actualRegion.contains(regDataRegion));
    }
    @Test
    public void shouldCreateInstanceWithLocalSSDContainsRegistrationData(){
        String regDataLocalSSD = request.getLocalSsd();
        String actualLocalSSD = resultPage.getLocalSsdData();
        Assert.assertTrue(actualLocalSSD.contains(regDataLocalSSD));
    }
    @Test
    public void shouldCreateInstanceWithCommitmentTermContainsRegistrationData(){
        String regDataCommitmentTerm = request.getCommitmentTerm();
        String actualCommitmentTerm = resultPage.getCommitmentTermData();
        Assert.assertTrue(actualCommitmentTerm.contains(regDataCommitmentTerm));
    }
    @Test
    public void shouldCreateInstanceWithEstimatedCostEquals(){
        String expectedEstimatedCost = "4,024.56";
        String actualEstimatedCost = resultPage.getEstimateCostData();
        Assert.assertTrue(actualEstimatedCost.contains(expectedEstimatedCost));

    }
}
