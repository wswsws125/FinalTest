package com.example.wswsw.inclassassignment10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReadingApp extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference UserRef = database.getReference("User");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_app);
    }

    public void setUser(View view){
        UserRef.setValue("new user");
    }

    public void logOut(View view){
        startActivity(new Intent(ReadingApp.this, MainActivity.class));
    }
}
