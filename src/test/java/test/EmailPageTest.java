package test;
import org.testng.Assert;
import org.testng.annotations.Test;



public class EmailPageTest extends BaseTest {


    @Test
    public void shouldEmailEstimatedCostEqualsPageResultEstimatedCost(){
        String expectedCost = resultPage.getEstimateCostData();
        String actualCost = resultPage.getEmailForm().sendEmail().openEmailPage().getEstimateCost();

        Assert.assertTrue(expectedCost.contains(actualCost));

    }
}
