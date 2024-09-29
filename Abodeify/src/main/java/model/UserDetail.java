package model;

public class UserDetail {

    public UserDetail userDetail;
    private String userName; // Username of the user
    private String password; // Password of the user
    private String role;

    // Getters and setters for each field
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "UserDetail [userDetail=" + userDetail + ", userName=" + userName + ", password=" + password + ", role="
                + role + "]";

    }
}
