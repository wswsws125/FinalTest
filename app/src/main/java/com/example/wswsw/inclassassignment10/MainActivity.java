package com.example.wswsw.inclassassignment10;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText mEmailField;
    private EditText mPasswordField;

    private Button mLoginBtn;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();

        mEmailField=(EditText)findViewById(R.id.emailField);
        mPasswordField=(EditText)findViewById(R.id.passwordField);

        mLoginBtn=(Button)findViewById(R.id.login_button);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //if the user has logged out
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }

            }
        };

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null)
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void onStop(){
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }

    }

    private void startSignIn(){
      String email=mEmailField.getText().toString();
      String password=mPasswordField.getText().toString();

      if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)) {
          Toast.makeText(MainActivity.this, "Field is empty", Toast.LENGTH_SHORT).show();


      }else{
          mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (!task.isSuccessful()) {
                      Toast.makeText(MainActivity.this, "Sign in problem", Toast.LENGTH_SHORT).show();
                  } else {
                      Toast.makeText(MainActivity.this, task.getResult().getUser().getEmail() + "logged in successful", Toast.LENGTH_SHORT).show();
                      if(task.isSuccessful()){
                          startActivity(new Intent(MainActivity.this,ReadingApp.class));}
                      }
              }
          });
      }
    }
}
