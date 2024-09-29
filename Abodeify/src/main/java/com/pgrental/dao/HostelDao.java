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

import model.HostelDetail;

/**
 * Data Access Object (DAO) class for hostel entities.
 */
public class HostelDao {
    public static Firestore db;

    public HostelDao() {
    }

    public static void addData(String collection, String document, HostelDetail data)
            throws ExecutionException, InterruptedException {
        System.out.println("hostel" + db);
        DocumentReference hosteldocRef = db.collection(collection).document(document); // Reference to the document

        ApiFuture<WriteResult> result = hosteldocRef.set(data); // Set data in the document
        result.get(); // Block until operation is complete
    }

    public static HostelDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference hosteldocRef = db.collection(collection).document(document); // Reference to the document
            ApiFuture<DocumentSnapshot> future = hosteldocRef.get(); // Asynchronously retrieve document snapshot
            return future.get().toObject(HostelDetail.class); // Convert document snapshot to hostel object
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    public List<HostelDetail> getDataList(String collection) throws ExecutionException, InterruptedException {
        try {
            CollectionReference colRef = db.collection(collection); // Reference to the collection
            ApiFuture<QuerySnapshot> future = colRef.get(); // Asynchronously retrieve all documents in collection
            QuerySnapshot querySnapshot = future.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
            List<HostelDetail> dataList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                HostelDetail object = document.toObject(HostelDetail.class); // Convert each document snapshot to hostel
                                                                             // object
                dataList.add(object); // Add hostel object to list
            }
            return dataList; // Return list of hostel objects
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }
}