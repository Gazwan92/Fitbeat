package com.example.fitbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Eating1 extends AppCompatActivity {
    EditText eatEt;
    int eatresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eating1);
        eatEt = findViewById(R.id.editText);
    }



    public void nextscreen(View view) {

        Intent intent = new Intent(Eating1.this, Junkfood.class);
        String eat = eatEt.getText().toString();
        int eatnum = Integer.valueOf(eat);
        eatresult = (eatnum*600);
        intent.putExtra("eatresult",eatresult);
        startActivity(intent);
    }
}
