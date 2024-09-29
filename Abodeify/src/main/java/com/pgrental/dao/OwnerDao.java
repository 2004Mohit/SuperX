

package com.pgrental.dao;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import model.OwnerDetail;

public class OwnerDao {
    public static Firestore db;

    public void addData(String collection, String document, Map<String, Object> data)
            throws ExecutionException, InterruptedException {
        System.out.println(db);
        DocumentReference docRef = db.collection(collection).document(document);

        ApiFuture<WriteResult> result = docRef.set(data);

        result.get();
    }

    public OwnerDetail getData(String collection, String document)
            throws ExecutionException, InterruptedException {

        try {
            DocumentReference docRef = db.collection(collection).document(document);

            ApiFuture<DocumentSnapshot> future = docRef.get();

            return future.get().toObject(OwnerDetail.class);

        } catch (Exception e) {
            e.printStackTrace();

            throw e;

        }
    }
}
