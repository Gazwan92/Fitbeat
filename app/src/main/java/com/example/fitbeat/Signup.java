package com.example.fitbeat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText emailEt;
    EditText passEt;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
    }

    private void init() {
        emailEt = findViewById(R.id.editText);
        passEt = findViewById(R.id.editText2);
        auth=FirebaseAuth.getInstance();

    }

//    public void signupBtn(View view) {
//
//        Intent intent = new Intent(Signup.this, MainActivity.class);
//        startActivity(intent);
//    }

    public void loginBtn(View view) {

        String email = emailEt.getText().toString();
        String pass = passEt.getText().toString();

        if (email.isEmpty()) {
            emailEt.setError("Email required");
        } else if (pass.isEmpty()) {
            passEt.setError("Password required");
        } else {

            loginUser(email, pass);

        }

    }

    private void loginUser(String email, String pass) {

        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Signup.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
