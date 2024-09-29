package com.pgrental.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.pgrental.dao.OwnerDao;
import com.pgrental.dao.TenantInfoDao;
import com.pgrental.dao.UserDao;
import com.pgrental.dao.FlatDao;
import com.pgrental.dao.HostelDao;
import com.pgrental.dao.PgDao;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class for initializing Firebase configuration.
 */
public class FirebaseInitialization {
    // Static block to initialize Firebase upon class loading
    static {
        try {
            initializeFirebase(); // Call method to initialize

        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException if thrown
        }
    }

    /**
        * Method to initialize Firebase.
        * @throws IOException if there is an issue reading the
        service account file.
        */
        private static void initializeFirebase() throws IOException {
        // Load Firebase service account credentials from a JSON
        
        FileInputStream serviceAccount = new FileInputStream("src\\main\\resources\\ABODEIFY-fx.json");
        // Create FirebaseOptions object to configure Firebase
        
        
        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
        
        // Initialize Firebase App with the configured
        
        
        FirebaseApp.initializeApp(options);

        // Access Firestore database instance
        Firestore db = FirestoreClient.getFirestore();
    
        UserDao.db = db;
        OwnerDao.db = db;
        HostelDao.db = db;
        FlatDao.db = db;
        PgDao.db = db;
        TenantInfoDao.db = db;
        }
}
