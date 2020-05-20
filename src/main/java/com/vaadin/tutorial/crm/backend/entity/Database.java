package com.vaadin.tutorial.crm.backend.entity;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Database {
    private static final String DATABASE_URL = "https://fir-test-61b2a.firebaseio.com/";
    private static Database instance;
    private static FirebaseDatabase firebaseDatabase;

    private Database(){
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.getApplicationDefault())
                    .setDatabaseUrl("https://fir-test-61b2a.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
            firebaseDatabase = FirebaseDatabase.getInstance(DATABASE_URL);
        }catch(IOException e){

        }

    }
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public void update(Object value) {
        update(value, "testdata");
    }

    public void update(Object value, String key) {
        try {
            DatabaseReference ref = firebaseDatabase.getReference(key);
            final CountDownLatch latch = new CountDownLatch(1);
            ref.setValue(value, (databaseError, databaseReference) -> {
                if (databaseError != null) {
                    System.out.println("Data could not be saved " + databaseError.getMessage());
                    latch.countDown();
                } else {
                    System.out.println("Data saved successfully.");
                    latch.countDown();
                }
            });
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        firebaseDatabase.getApp().delete();
    }
}