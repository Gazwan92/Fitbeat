package com.example.fitbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Height1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height1);
    }

    public void nextscreen(View view) {
        Intent intent = new Intent(Height1.this, Eating1.class);
        startActivity(intent);
    }
}
