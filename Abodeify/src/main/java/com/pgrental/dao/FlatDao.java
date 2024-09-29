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

import model.FlatDetail;

/**
 * Data Access Object (DAO) class for flat entities.
 */
public class FlatDao {
    public static Firestore db;

    public FlatDao() {
        
    }

    public static void addData(String collection, String document, FlatDetail data)
            throws ExecutionException, InterruptedException {
        System.out.println("flat" + db);
        DocumentReference flatdocRef = db.collection(collection).document(document); // Reference to the document

        ApiFuture<WriteResult> result = flatdocRef.set(data); // Set data in the document
        result.get(); // Block until operation is complete
    }

    public static FlatDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference flatdocRef = db.collection(collection).document(document); // Reference to the document
            ApiFuture<DocumentSnapshot> future = flatdocRef.get(); // Asynchronously retrieve document snapshot
            return future.get().toObject(FlatDetail.class); // Convert document snapshot to flat object
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    public List<FlatDetail> getDataList(String collection) throws ExecutionException, InterruptedException {
        try {
            CollectionReference colRef = db.collection(collection); // Reference to the collection
            ApiFuture<QuerySnapshot> future = colRef.get(); // Asynchronously retrieve all documents in collection
            QuerySnapshot querySnapshot = future.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
            List<FlatDetail> dataList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                FlatDetail object = document.toObject(FlatDetail.class); // Convert each document snapshot to flat
                                                                             // object
                dataList.add(object); // Add flat object to list
            }
            return dataList; // Return list of flat objects
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

}