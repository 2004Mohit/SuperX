package com.pgrental.DashBoard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.FlatDao;
import com.pgrental.dataAccess.LoginPage;

import model.FlatDetail;

/**
 * Controller class to manage flat-related operations.
 */
public class FlatController {
    private String flat_UniqueID = null;

    LoginPage OwnerLogin = new LoginPage();
    String OwnerName = OwnerLogin.statusOwner;
    private FlatDao flatDao = new FlatDao(); // Instanceof flatDao to interact with the database

    public List<FlatDetail> getflatData() {
        try {
            return flatDao.getDataList("Flat");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public boolean addflatData(FlatDetail flatData) {
        flat_UniqueID = LoginPage.statusOwner + ": " + flatData.getFlatOwner();
        System.out.println(flatData);
        try {
            // flatDao.addData("Flat", OwnerLogin.statusOwner+, flatData); // Add player to
            // the "player" collection
            flatDao.addData("Flat", flat_UniqueID, flatData); // Add player to the "player" collection

            return true; // Return true if the player is added successfully

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return false; // Return false if an exception occurs
    }

    /**
     * Method to get flat details based on flatname.
     * 
     * @param flatname The flatname of the flat.
     * @return flatDetail object containing flat details, or null
     *         if an exception occurs.
     */
    public FlatDetail getflatDetail(String flatname) {
        try {
            return flatDao.getData("flat", flatname); // Retrieve flat details from the database
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return null; // Return null if an exception occurs
    }
}