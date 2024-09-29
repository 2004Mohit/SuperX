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

import model.PgDetail;

/**
 * Data Access Object (DAO) class for pg entities.
 */
public class PgDao {
    public static Firestore db;

    public PgDao() {
    }

    public static void addData(String collection, String document, PgDetail data)
            throws ExecutionException, InterruptedException {
        System.out.println("PG" + db);
        DocumentReference pgdocRef = db.collection(collection).document(document); // Reference to the document

        ApiFuture<WriteResult> result = pgdocRef.set(data); // Set data in the document
        result.get(); // Block until operation is complete
    }

    public static PgDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference pgdocRef = db.collection(collection).document(document); // Reference to the document
            ApiFuture<DocumentSnapshot> future = pgdocRef.get(); // Asynchronously retrieve document snapshot
            return future.get().toObject(PgDetail.class); // Convert document snapshot to pg object
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

    public List<PgDetail> getDataList(String collection) throws ExecutionException, InterruptedException {
        try {
            CollectionReference colRef = db.collection(collection); // Reference to the collection
            ApiFuture<QuerySnapshot> future = colRef.get(); // Asynchronously retrieve all documents in collection
            QuerySnapshot querySnapshot = future.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments(); // Extract list of document snapshots
            List<PgDetail> dataList = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                PgDetail object = document.toObject(PgDetail.class); // Convert each document snapshot to pg
                                                                             // object
                dataList.add(object); // Add pg object to list
            }
            return dataList; // Return list of pg objects
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw e; // Re-throw exception or handle based on application's needs
        }
    }

}