package com.pgrental.DashBoard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.PgDao;
import com.pgrental.dataAccess.LoginPage;

import model.PgDetail;

/**
 * Controller class to manage pg-related operations.
 */
public class PgController {
    private String PG_UniqueID = null;
    private PgDao pgDao = new PgDao(); // Instanceof pgDao to interact with the database

    public List<PgDetail> getpgData() {
        try {
            return pgDao.getDataList("PG");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // private DataService pgDao = new DataService();
    /**
     * Method to authenticate a pg based on pgname and
     * password.
     * 
     * @param pgname   The pgname of the pg.
     * @param password The password of the pg.
     * @return true if the authentication is successful, false
     *         otherwise.
     */
    public boolean getpgData(String pgOwnerName) {
        try {
            PgDetail pg = pgDao.getData("PG", pgOwnerName); // Retrieve pg details from the database

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return false; // Return false if authentication fails or an exception occurs
    }

    public boolean addpgData(PgDetail pgData) {
        System.out.println(pgData);
        PG_UniqueID = LoginPage.statusOwner + ": " + pgData.getPgName();
        System.out.println(PG_UniqueID);
        try {
            pgDao.addData("PG", PG_UniqueID, pgData); // Add player to the "player" collection

            return true; // Return true if the player is added successfully

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return false; // Return false if an exception occurs
    }


    /**
     * Method to get pg details based on pgname.
     * 
     * @param pgname The pgname of the pg.
     * @return pgDetail object containing pg details, or null
     *         if an exception occurs.
     */
    public PgDetail getpgDetail(String pgname) {
        try {
            return pgDao.getData("pg", pgname); // Retrieve pg details from the database
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return null; // Return null if an exception occurs
    }
}