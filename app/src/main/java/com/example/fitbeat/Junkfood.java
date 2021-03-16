package com.example.fitbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Junkfood extends AppCompatActivity {

    double junkresult;

    double eatresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junkfood);
        Intent intent = getIntent();
         eatresult= intent.getIntExtra("eatresult",0);
        //int junknum = Integer.valueOf(eatresult);




    }

    public void nextscreen(View view) {

        junkresult  = ((eatresult*0.2)+eatresult);
        Intent intent = new Intent(Junkfood.this, Exercise1.class);
        intent.putExtra("junkresult",junkresult);
        startActivity(intent);
    }

    public void nextscreen1(View view) {
        Intent intent = new Intent(Junkfood.this, Exercise1.class);
        intent.putExtra("junkresult",eatresult);
        startActivity(intent);
    }
}
