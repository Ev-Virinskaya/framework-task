package model;

import java.util.Objects;

public class Request {
    private String searchRequest;

    private String numberOfInstance;
    private String osType;
    private String vmClass;
    private String series;
    private String instanceType;
    private String gpuType;
    private String gpuNumber;
    private String region;
    private String localSsd;
    private String commitmentTerm;

    public Request() {
    }

    public String getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(String searchRequest) {
        this.searchRequest = searchRequest;
    }
    public String getNumberOfInstance() {
        return numberOfInstance;
    }

    public void setNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getGpuNumber() {
        return gpuNumber;
    }

    public void setGpuNumber(String gpuNumber) {
        this.gpuNumber = gpuNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getCommitmentTerm() {
        return commitmentTerm;
    }

    public void setCommitmentTerm(String commitmentTerm) {
        this.commitmentTerm = commitmentTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return searchRequest.equals(request.searchRequest) && numberOfInstance.equals(request.numberOfInstance) && osType.equals(request.osType) && vmClass.equals(request.vmClass) && series.equals(request.series) && instanceType.equals(request.instanceType) && gpuType.equals(request.gpuType) && gpuNumber.equals(request.gpuNumber) && region.equals(request.region) && localSsd.equals(request.localSsd) && commitmentTerm.equals(request.commitmentTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchRequest, numberOfInstance, osType, vmClass, series, instanceType, gpuType, gpuNumber, region, localSsd, commitmentTerm);
    }

    @Override
    public String toString() {
        return "Request{" +
                "searchRequest='" + searchRequest + '\'' +
                ", numberOfInstance='" + numberOfInstance + '\'' +
                ", osType='" + osType + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", series='" + series + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", gpuNumber='" + gpuNumber + '\'' +
                ", region='" + region + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", commitmentTerm='" + commitmentTerm + '\'' +
                '}';
    }
}
