package com.pgrental.DashBoard.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.OwnerDao;
import com.pgrental.dao.UserDao;

import model.UserDetail;

/**
 * Controller class to manage user-related operations.
 */
public class UserController {
   private UserDao userDao = new UserDao(); // Instanceof UserDao to interact with the database
   private OwnerDao ownerDao = new OwnerDao();
//    private String Text;
   OwnerController ownerController = new OwnerController();
   
// private DataService userDao = new DataService();
/**
* Method to authenticate a user based on username and
password.
* @param username The username of the user.
* @param password The password of the user.
* @return true if the authentication is successful, false
otherwise.
*/
public boolean authenticateUser(String username,String password) {
    try {
        UserDetail user = userDao.getData("user", username); // Retrieve user details from the database
        System.out.println(user);
        System.out.println(password);
        
        if (user != null) {
        String storedPassword = user.getPassword(); // Get the stored password
       
        return password.equals(storedPassword); // Compare stored password with the provided password
        
        
        }
        } catch (ExecutionException | InterruptedException ex) {
        ex.printStackTrace(); // Print stack trace for debugging

        
        }
        return false; // Return false if authentication fails or an exception occurs
        }

    /**
     * Method to handle user signup.
     * 
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return true if the signup is successful, false otherwise.
     */
    public boolean handleSignup(String Text, String username, String password) {
        try {
            // Create a map to store user details
            Map<String, Object> data = new HashMap<>();
            data.put("password", password); // Add password to the map

            data.put("userName", username); // Add username to the map

            if(Text == "Tenant") // Add user role to the map 
            {
                data.put("role", "USER"); // Add user role to the map
                userDao.addData("user", username, data); // Add user details to the database
            } else {
                data.put("role", "Owner"); // Add user role to the map
                ownerDao.addData("Owner", username, data); // Add user details to the database
            }
            System.out.println("User registered successfully");

            // Print success message

            return true; // Return true if signup is successful
        } catch (Exception ex) {
            ex.printStackTrace(); // Print stack trace for debugging

            return false; // Return false if an exception occurs
        }
    }

    /**
     * Method to get user details based on username.
     * 
     * @param username The username of the user.
     * @return UserDetail object containing user details, or null
     *         if an exception occurs.
     */
    public UserDetail getUserDetail(String username) {
        try {
            return userDao.getData("user", username); // Retrieve user details from the database
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return null; // Return null if an exception occurs
    }
}