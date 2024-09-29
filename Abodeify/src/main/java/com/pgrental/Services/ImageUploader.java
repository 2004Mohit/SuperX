package com.pgrental.Services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ImageUploader {

    private static final String BUCKET_NAME = "abodeify-fx.appspot.com";

    public static String uploadImage(String localFilePath,
            String uploadFileName) {
        try {
            FileInputStream serviceAccount = new FileInputStream("Abodeify\\src\\main\\resources\\abodeify-fx.json");

            Storage storage = StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build().getService();
            Path path = Paths.get(localFilePath);
            byte[] bytes = Files.readAllBytes(path);

            BlobId blobId = BlobId.of(BUCKET_NAME, uploadFileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg")
                    .setAcl(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))).build(); 
            storage.create(blobInfo, bytes);

            return "https://storage.googleapis.com/" +
                    BUCKET_NAME + "/" + uploadFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}