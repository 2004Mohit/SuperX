package model;

public class HostelDetail {

    private String OwnerName;
    private String hostelName;
    private String Gender;
    private String ownBy;
    private String HostelOwner;
    private String address;
    private String noofBeds;
    private String hostelFees;
    private String deposit;
    private String hostelImg;

    public HostelDetail() {
        
    }

    public HostelDetail(String OwnerName, String hostelName, String Gender, String ownBy, String HostelOwner,
            String address, String noofBeds, String hostelFees, String deposit) {
        this.OwnerName = OwnerName;
        this.hostelName = hostelName;
        this.Gender = Gender;
        this.ownBy = ownBy;
        this.HostelOwner = HostelOwner;
        this.address = address;
        this.noofBeds = noofBeds;
        this.hostelFees = hostelFees;
        this.deposit = deposit;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getOwnBy() {
        return ownBy;
    }

    public void setOwnBy(String ownBy) {
        this.ownBy = ownBy;
    }

    public String getHostelOwner() {
        return HostelOwner;
    }

    public void setHostelOwner(String hostelOwner) {
        HostelOwner = hostelOwner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoofBeds() {
        return noofBeds;
    }

    public void setNoofBeds(String noofBeds) {
        this.noofBeds = noofBeds;
    }

    public String getHostelFees() {
        return hostelFees;
    }

    public void setHostelFees(String hostelFees) {
        this.hostelFees = hostelFees;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getHostelImg() {
        return hostelImg;
    }

    public void setHostelImg(String hostelImg) {
        this.hostelImg = hostelImg;
    }

    @Override
    public String toString() {
        return "hostelDetail [OwnerName=" + OwnerName + ", hostelName=" + hostelName + ", Gender=" + Gender + ", ownBy="
                + ownBy + ", HostelOwner=" + HostelOwner + ", address=" + address + ", noofBeds=" + noofBeds
                + ", hostelFees=" + hostelFees + ", deposit=" + deposit + ", hostelImg=" + hostelImg + "]";
    }
}