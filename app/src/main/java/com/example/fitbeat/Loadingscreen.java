package com.example.fitbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Loadingscreen extends AppCompatActivity {
    double exerciseresult;
    double junkResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingscreen);
        Intent intent = getIntent();
        junkResult= intent.getDoubleExtra("exerciseresult1",0.0);
        exerciseresult= intent.getDoubleExtra("exerciseresult",0.0);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Loadingscreen.this,Caloriecount.class);
                intent.putExtra("exerciseresult",exerciseresult);
                intent.putExtra("exerciseresult1",junkResult);
                startActivity(intent);
                finish();
            }
        },3000);



    }
}
