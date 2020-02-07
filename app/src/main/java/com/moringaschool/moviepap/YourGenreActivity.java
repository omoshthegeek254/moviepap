package com.moringaschool.moviepap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class YourGenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_genre);

        Intent intent = getIntent();
        String genre1 = intent.getStringExtra("gen11");
        String genre2 = intent.getStringExtra("gen22");
        String genre3 = intent.getStringExtra("gen33");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView7);
        textView.setText(genre1);

        TextView textView2 = findViewById(R.id.textView8);
        textView2.setText(genre2);

        TextView textView3 = findViewById(R.id.textView9);
        textView3.setText(genre3);
    }
}
