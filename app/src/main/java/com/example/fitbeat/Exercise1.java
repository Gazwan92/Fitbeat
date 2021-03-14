package com.example.fitbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Exercise1 extends AppCompatActivity {
    EditText exerciseEt;
    double exerciseresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        exerciseEt = findViewById(R.id.editText);
    }

    public void nextscreen(View view) {
        String exercise = exerciseEt.getText().toString();
        int exercisenum = Integer.valueOf(exercise);
        exerciseresult = (exercisenum*13.33333);
        Intent intent = new Intent(Exercise1.this, Caloriecount.class);
        intent.putExtra("exerciseresult",exerciseresult);
        startActivity(intent);
    }
}
