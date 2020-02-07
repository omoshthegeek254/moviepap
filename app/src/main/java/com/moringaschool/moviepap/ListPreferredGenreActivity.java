package com.moringaschool.moviepap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ListPreferredGenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_preferred_genre);




        //getting intent variables
        Intent intent = getIntent();

        //capturing intent vars
        String gen1Msg = intent.getStringExtra("gen11");
        String gen2Msg = intent.getStringExtra("gen22");
        String gen3Msg = intent.getStringExtra("gen33");

        //finding text views

        TextView textViewG1 = findViewById(R.id.textView4);
        TextView textViewG2 = findViewById(R.id.textView5);
        TextView textViewG3 = findViewById(R.id.textView6);
//displaying intet var on individual views

        textViewG1.setText("1. " + gen1Msg);
        textViewG2.setText("2. " + gen2Msg);
        textViewG3.setText("1. " + gen3Msg);
        startActivity(intent);
    }


}
