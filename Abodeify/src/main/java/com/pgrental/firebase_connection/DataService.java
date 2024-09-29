package com.pgrental.firebase_connection;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import model.UserDetail;

public class DataService {

    private static Firestore db;

    public void addData(String collection, String document, Map<String, Object> data)
            throws ExecutionException, InterruptedException {
                
        DocumentReference docRef = db.collection(collection).document(document);

        ApiFuture<WriteResult> result = docRef.set(data);

        result.get();

    }

    public void addHostelData(String collection, String document, Object data)
            throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection(collection).document(document);

        ApiFuture<WriteResult> result = docRef.set(data);

        result.get();

    }

    public UserDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference docRef = db.collection(collection).document(document);

            ApiFuture<DocumentSnapshot> future = docRef.get();
            return future.get().toObject(UserDetail.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean authenticateUser(String username, String password) throws ExecutionException, InterruptedException {

        DocumentSnapshot document = db.collection("users").document(username).get().get();
        if (document.exists()) {
            String storedPassword = document.getString("password");
            return password.equals(storedPassword);
        }
        return false;
    }
}