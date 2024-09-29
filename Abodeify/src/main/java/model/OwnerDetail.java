package model;

public class OwnerDetail {

    private String OwnerName; // Ownername of the Owner
    private String password; // Password of the Owner
    private String role;

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "Owner [OwnerName=" + OwnerName + ", OwnerRole=" + role + "]";
    }

}
