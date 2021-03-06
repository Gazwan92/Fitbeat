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

public class MainActivity extends AppCompatActivity {
    EditText emailEt;
    EditText passEt;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(MainActivity.this, Male_female.class);
            startActivity(intent);
        }
    }

    private void init() {
        emailEt = findViewById(R.id.editText4);
        passEt = findViewById(R.id.editText5);
        auth = FirebaseAuth.getInstance();

    }

    public void signup(View view) {
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);
    }

    private void loginUser(String email, String pass) {

        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, Male_female.class);
                    startActivity(intent);
                } else
                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void login(View view) {
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
}