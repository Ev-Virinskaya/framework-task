package service;

import model.Request;
import page.CalculatorForm;
import page.ResultPage;

public class RequestCreator {

    public static ResultPage fillFields(Request request, CalculatorForm calculatorForm) {
        return  calculatorForm.choiceComputeEngine()
                .choiceNumberOfInstance(request)
                .choiceOsType(request)
                .choiceVmClass(request)
                .choiceSeries(request)
                .choiceInstanceType(request)
                .choiceGPUCheckbox()
                .choiceGpuType(request)
                .choiceGpuNumber(request)
                .choiceLocalSsd(request)
                .choiceRegion(request)
                .choiceCommitmentTerm(request)
                .getEstimateButton();

    }
}
