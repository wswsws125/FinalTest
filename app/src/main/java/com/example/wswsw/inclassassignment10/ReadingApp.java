package com.example.wswsw.inclassassignment10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReadingApp extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference UserRef = database.getReference("User");
    private Button start_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_app);


        start_btn=(Button) findViewById(R.id.start_reading);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startReading();
            }
        });

    }

    public void startReading(){
        startActivity(new Intent(ReadingApp.this, QuestionPage.class));
    }

    public void setUser(View view){
        UserRef.setValue("new user");
    }

    public void logOut(View view){
        startActivity(new Intent(ReadingApp.this, MainActivity.class));
    }
}
