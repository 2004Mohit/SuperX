package model;

public class TenantInfoDetail {
    private String firstName;
    private String LastName;
    private String Name;
    private String phoneNo;
    private String Address;
    private String Occupation;
    private String Gender;
    private String setDate;
    private String profile;

    public TenantInfoDetail() {
    }

    public TenantInfoDetail(String firstName, String lastName, String phoneNo, String address, String occupation,
            String gender, String setDate) {
        this.firstName = firstName;
        this.LastName = lastName;
        this.phoneNo = phoneNo;
        this.Address = address;
        this.Occupation = occupation;
        this.Gender = gender;
        this.setDate = setDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        Name = firstName + " " + LastName;
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getSetDate() {
        return setDate;
    }

    public void setSetDate(String setDate) {
        this.setDate = setDate;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "TenantInfoDetail [firstName=" + firstName + ", LastName=" + LastName + ", Name=" + Name + ", phoneNo="
                + phoneNo + ", Address=" + Address + ", Occupation=" + Occupation + ", Gender=" + Gender + ", setDate="
                + setDate + ", profile=" + profile + "]";
    }

}
