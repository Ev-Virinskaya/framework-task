package service;

import model.Request;

public class RequestCreator {
    private static final String TESTDATA_SEARCH_REQUEST = "testdata.request.searchRequest";
    private static final String TESTDATA_NUMBER_OF_INSTANCE = "testdata.request.numberOfInstance";
    private static final String TESTDATA_OS_TYPE = "testdata.request.osType";
    private static final String TESTDATA_VM_CLASS = "testdata.request.vmClass";
    private static final String TESTDATA_SERIES = "testdata.request.series";
    private static final String TESTDATA_INSTANCE_TYPE = "testdata.request.instanceType";
    private static final String TESTDATA_GPU_TYPE = "testdata.request.gpuType";
    private static final String TESTDATA_GPU_NUMBER = "testdata.request.gpuNumber";
    private static final String TESTDATA_REGION = "testdata.request.region";
    private static final String TESTDATA_LOCAL_SSD = "testdata.request.localSsd";
    private static final String TESTDATA_COMMITMENT_TERM = "testdata.request.commitmentTerm";

    public static Request withRegDataFromProperty(){
        Request request = new Request();
        request.setSearchRequest(TestDataReader.getTestData(TESTDATA_SEARCH_REQUEST));
        request.setNumberOfInstance(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCE));
        request.setOsType(TestDataReader.getTestData(TESTDATA_OS_TYPE));
        request.setVmClass(TestDataReader.getTestData(TESTDATA_VM_CLASS));
        request.setSeries(TestDataReader.getTestData(TESTDATA_SERIES));
        request.setInstanceType(TestDataReader.getTestData(TESTDATA_INSTANCE_TYPE));
        request.setGpuType(TestDataReader.getTestData(TESTDATA_GPU_TYPE));
        request.setGpuNumber(TestDataReader.getTestData(TESTDATA_GPU_NUMBER));
        request.setRegion(TestDataReader.getTestData(TESTDATA_REGION));
        request.setLocalSsd(TestDataReader.getTestData(TESTDATA_LOCAL_SSD));
        request.setCommitmentTerm(TestDataReader.getTestData(TESTDATA_COMMITMENT_TERM));

        return request;
    }
}
