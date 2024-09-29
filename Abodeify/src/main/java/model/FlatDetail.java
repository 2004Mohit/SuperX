package model;

public class FlatDetail {
    private String flatOwner;
    private String city;
    private String buildingName;
    private String flatAddress;
    private String bhk;
    private String rent;
    private String availableFrom;
    private String flatDeposit;
    private String flatImg;

    public FlatDetail() {
        
    }

    public FlatDetail(String flatOwner, String city, String buildingName, String flatAddress, String bhk, String rent,
            String availableFrom, String flatDeposit) {
        this.flatOwner = flatOwner;
        this.city = city;
        this.buildingName = buildingName;
        this.flatAddress = flatAddress;
        this.bhk = bhk;
        this.rent = rent;
        this.availableFrom = availableFrom;
        this.flatDeposit = flatDeposit;
    }

    public String getFlatOwner() {
        return flatOwner;
    }

    public void setFlatOwner(String flatOwner) {
        this.flatOwner = flatOwner;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getFlatAddress() {
        return flatAddress;
    }

    public void setFlatAddress(String flatAddress) {
        this.flatAddress = flatAddress;
    }

    public String getBhk() {
        return bhk;
    }

    public void setBhk(String bhk) {
        this.bhk = bhk;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(String availableFrom) {
        this.availableFrom = availableFrom;
    }

    public String getFlatDeposit() {
        return flatDeposit;
    }

    public void setFlatDeposit(String flatDeposit) {
        this.flatDeposit = flatDeposit;
    }

    public String getFlatImg() {
        return flatImg;
    }

    public void setFlatImg(String flatImg) {
        this.flatImg = flatImg;
    }

    @Override
    public String toString() {
        return "flatDetail [flatOwner=" + flatOwner + ", city=" + city + ", buildingName=" + buildingName
                + ", flatAddress=" + flatAddress + ", bhk=" + bhk + ", rent=" + rent + ", availableFrom="
                + availableFrom + ", flatDeposit=" + flatDeposit + ", flatImg=" + flatImg + "]";
    }

}