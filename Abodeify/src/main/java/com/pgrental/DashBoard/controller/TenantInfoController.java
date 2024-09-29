package com.pgrental.DashBoard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.TenantInfoDao;

import model.TenantInfoDetail;

/**
 * Controller class to manage TenantInfo-related operations.
 */
public class TenantInfoController {
    private String TenantName = null;

    private TenantInfoDao TenantInfoDao = new TenantInfoDao(); // Instanceof TenantInfoDao to interact with the database

    public List<TenantInfoDetail> getTenantInfoData() {
        try {
            return TenantInfoDao.getDataList("TenantInfo");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // private DataService TenantInfoDao = new DataService();
    /**
     * Method to authenticate a TenantInfo based on TenantInfoname and
     * password.
     * 
     * @param TenantInfoname The TenantInfoname of the TenantInfo.
     * @param password  The password of the TenantInfo.
     * @return true if the authentication is successful, false
     *         otherwise.
     */
    public boolean getTenantInfoData(String TenantInfoName) {
        try {
            TenantInfoDetail TenantInfo = TenantInfoDao.getData("TenantInfo", TenantInfoName); // Retrieve TenantInfo details from the database

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return false; // Return false if authentication fails or an exception occurs
    }


    public boolean addTenantInfoData(TenantInfoDetail TenantInfoData) {
        System.out.println(TenantInfoData);
        TenantName = TenantInfoData.getLastName()+TenantInfoData.getFirstName();
        System.out.println(TenantInfoData);
        try {
            // TenantInfoDao.addData("TenantInfo", LoginPage.statusOwner, TenantInfoData); // Add player to the "player" collection

            TenantInfoDao.addData("TenantInfo", TenantName, TenantInfoData); // Add player to the "player" collection

            return true; // Return true if the player is added successfully

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return false; // Return false if an exception occurs
    }

    /**
     * Method to handle TenantInfo signup.
     * 
     * @param TenantInfoname The TenantInfoname of the new TenantInfo.
     * @param password  The password of the new TenantInfo.
     * @return true if the signup is successful, false otherwise.
     */
    // public boolean handleSignup(String TenantInfoname, String password) {
    //     try {
    //         // Create a map to store TenantInfo details
    //         Map<String, Object> data = new HashMap<>();
    //         data.put("password", password); // Add password to the map

    //         data.put("TenantInfoName", TenantInfoname); // Add TenantInfoname to the map

    //         data.put("role", "TenantInfo"); // Add TenantInfo role to the map
    //         TenantInfoDao.addData("TenantInfo", TenantInfoname, data); // Add TenantInfo details to the database

    //         System.out.println("TenantInfo registered successfully");

    //         // Print success message

    //         return true; // Return true if signup is successful
    //     } catch (Exception ex) {
    //         ex.printStackTrace(); // Print stack trace for debugging

    //         return false; // Return false if an exception occurs
    //     }
    // }

    /**
     * Method to get TenantInfo details based on TenantInfoname.
     * 
     * @param TenantInfoname The TenantInfoname of the TenantInfo.
     * @return TenantInfoDetail object containing TenantInfo details, or null
     *         if an exception occurs.
     */
    // public TenantInfoDetail getTenantInfoDetail(String TenantInfoname) {
    //     try {
    //         return TenantInfoDao.getData("TenantInfo", TenantInfoname); // Retrieve TenantInfo details from the database
            
    //     } catch (ExecutionException | InterruptedException ex) {
    //         ex.printStackTrace(); // Print stack trace for debugging

    //     }
    //     return null; // Return null if an exception occurs
    // }
}