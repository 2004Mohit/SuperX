package com.pgrental.DashBoard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.pgrental.dao.HostelDao;
import com.pgrental.dataAccess.LoginPage;

import model.HostelDetail;

/**
 * Controller class to manage hostel-related operations.
 */
public class HostelController {
    private String hostel_UniqueID = null;

    LoginPage OwnerLogin = new LoginPage();
    String OwnerName = OwnerLogin.statusOwner;
    private HostelDao HostelDao = new HostelDao(); // Instanceof hostelDao to interact with the database

    public List<HostelDetail> gethostelData() {
        try {
            return HostelDao.getDataList("Hostel");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // private DataService hostelDao = new DataService();
    /**
     * Method to authenticate a hostel based on hostelname and
     * password.
     * 
     * @param hostelname The hostelname of the hostel.
     * @param password  The password of the hostel.
     * @return true if the authentication is successful, false
     *         otherwise.
     */
    public boolean getHostelData(String hostelOwnerName) {
        try {
            HostelDetail hostel = HostelDao.getData("Hostel", hostelOwnerName); // Retrieve hostel details from the database

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace(); // Print stack trace for debugging

        }
        return false; // Return false if authentication fails or an exception occurs
    }


    public boolean addHostelData(HostelDetail HostelData) {
        hostel_UniqueID = LoginPage.statusOwner+": "+ HostelData.getHostelName();
        System.out.println(HostelData);
        try {
            // hostelDao.addData("Hostel", LoginPage.statusOwner, HostelData); // Add player to the "player" collection

            HostelDao.addData("Hostel", hostel_UniqueID, HostelData); // Add player to the "player" collection

            return true; // Return true if the player is added successfully

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return false; // Return false if an exception occurs
    }
}