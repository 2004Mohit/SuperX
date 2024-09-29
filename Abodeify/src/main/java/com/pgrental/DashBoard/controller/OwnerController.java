package com.pgrental.DashBoard.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.OwnerDao;

import model.OwnerDetail;

/**
 * Controller class to manage Owner-related operations.
 */
public class OwnerController {
    private static OwnerDao OwnerDao = new OwnerDao(); // Instanceof OwnerDao to interact with the database

    // private DataService OwnerDao = new DataService();
    /**
     * Method to authenticate a Owner based on Ownername and
     * password.
     * 
     * @param Ownername The Ownername of the Owner.
     * @param password  The password of the Owner.
     * @return true if the authentication is successful, false
     *         otherwise.
     */
    public static boolean authenticateOwner(String Ownername, String password) {
        try {
            OwnerDetail Owner = OwnerDao.getData("Owner", Ownername); // Retrieve Owner details from the database

            if (Owner != null) {
                String storedPassword = Owner.getPassword(); // Get the stored password

                return password.equals(storedPassword); // Compare stored password with the provided password

            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return false; // Return false if authentication fails or an exception occurs
    }

    /**
     * Method to handle Owner signup.
     * 
     * @param Ownername The Ownername of the new Owner.
     * @param password  The password of the new Owner.
     * @return true if the signup is successful, false otherwise.
     */
    public boolean handleSignup(String Ownername, String password) {
        try {
            // Create a map to store Owner details
            Map<String, Object> data = new HashMap<>();
            data.put("password", password); // Add password to the map

            data.put("OwnerName", Ownername); // Add Ownername to the map

            data.put("role", "Owner"); // Add Owner role to the map
            OwnerDao.addData("Owner", Ownername, data); // Add Owner details to the database

            System.out.println("Owner registered successfully");

            // Print success message

            return true; // Return true if signup is successful
        } catch (Exception ex) {
            ex.printStackTrace(); // Print stack trace for debugging

            return false; // Return false if an exception occurs
        }
    }

    /**
     * Method to get Owner details based on Ownername.
     * 
     * @param Ownername The Ownername of the Owner.
     * @return OwnerDetail object containing Owner details, or null
     *         if an exception occurs.
     */
    public static OwnerDetail getOwnerDetail(String Ownername) {
        try {
            return OwnerDao.getData("Owner", Ownername); // Retrieve Owner details from the database
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return null; // Return null if an exception occurs
    }
}