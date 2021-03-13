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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Signup extends AppCompatActivity {
    EditText nameEt;
    EditText emailEt;
    EditText passEt;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
    }

    private void init() {
        emailEt = findViewById(R.id.editText);
        passEt = findViewById(R.id.editText2);
        nameEt = findViewById(R.id.editText3);
        auth = FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("User");

    }

//    public void signupBtn(View view) {
//
//        Intent intent = new Intent(Signup.this, MainActivity.class);
//        startActivity(intent);
//    }

    public void signup(View view) {
        String name = nameEt.getText().toString();
        String email = emailEt.getText().toString();
        String pass = passEt.getText().toString();

        if (name.isEmpty()) {
            nameEt.setError("Name required");
        }
        else if (email.isEmpty())
        {
            emailEt.setError("Email required");
        }
        else if (pass.isEmpty())
        {
            passEt.setError("Password required");
        }
        else {

            signup(name, email, pass);

        }

    }

    private void signup(final String name, final String email, final String pass) {

        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String key=auth.getCurrentUser().getUid();
                    Userdata user=new Userdata(name,email,pass);
                    reference.child(key).setValue(user);
                    Intent intent = new Intent(Signup.this, Male_female.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void back(View view) {
        Intent intent = new Intent(Signup.this, MainActivity.class);
        startActivity(intent);

    }


}
