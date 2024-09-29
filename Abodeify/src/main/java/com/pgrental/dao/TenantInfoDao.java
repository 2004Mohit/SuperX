package com.pgrental.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import model.TenantInfoDetail;

/**
 * Data Access Object (DAO) class for TenantInfo entities.
 */
public class TenantInfoDao {
    public static Firestore db;

    public TenantInfoDao() {
    }

    public static void addData(String collection, String document, TenantInfoDetail data)
            throws ExecutionException, InterruptedException {
        System.out.println("TenantInfo" + db);
        DocumentReference TenantInfodocRef = db.collection(collection).document(document); // Reference to the document

        ApiFuture<WriteResult> result = TenantInfodocRef.set(data); // Set data in the document
        result.get(); // Block until operation is complete
    }

    public static TenantInfoDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference TenantInfodocRef = db.collection(collection).document(document); // Reference to the document
            ApiFuture<DocumentSnapshot> future = TenantInfodocRef.get(); // Asynchronously retrieve document snapshot
            return future.get().toObject(TenantInfoDetail.class); // Convert document snapshot to TenantInfo object
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    public List<TenantInfoDetail> getDataList(String collection) throws ExecutionException, InterruptedException {
        try {
            CollectionReference colRef = db.collection(collection); // Reference to the collection
            ApiFuture<QuerySnapshot> future = colRef.get(); // Asynchronously retrieve all documents in collection
            QuerySnapshot querySnapshot = future.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
            List<TenantInfoDetail> dataList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                TenantInfoDetail object = document.toObject(TenantInfoDetail.class); // Convert each document snapshot to TenantInfo
                                                                             // object
                dataList.add(object); // Add TenantInfo object to list
            }
            return dataList; // Return list of TenantInfo objects
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

}