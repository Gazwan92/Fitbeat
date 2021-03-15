package com.example.fitbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Caloriecount extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriecount);


        tv1 = findViewById(R.id.textView5);
        tv2 = findViewById(R.id.textView6);
        Intent intent = getIntent();
        String eatresult = String.valueOf(intent.getDoubleExtra("exerciseresult", 0.0));
        String eatresult1 = String.valueOf(intent.getDoubleExtra("exerciseresult1", 0.0));
        tv1.setText(eatresult);
        tv2.setText(eatresult1);
        auth = FirebaseAuth.getInstance();
    }

    public void logout(View view) {
        auth.signOut();
        Intent intent = new Intent(Caloriecount.this, MainActivity.class);
        startActivity(intent);
    }

    public void tryagain(View view) {
        Intent intent = new Intent(Caloriecount.this, Male_female.class);
        startActivity(intent);

    }
}
