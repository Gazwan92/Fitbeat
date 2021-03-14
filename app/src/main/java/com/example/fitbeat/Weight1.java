package com.example.fitbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Weight1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight1);

    }


    public void nextscreen(View view) {
        Intent intent = new Intent(Weight1.this, Height1.class);
        startActivity(intent);
    }
}
