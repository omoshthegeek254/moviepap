package com.moringaschool.moviepap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddGenreActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_genre);


    }
    /** Called when the user taps the Send button */
    public void saveGenre(View view) {
        Intent i = new Intent(this, YourGenreActivity.class);


        EditText gen1 = (EditText) findViewById(R.id.editText);

        EditText gen2 = (EditText) findViewById(R.id.editText1);

        EditText gen3 = (EditText) findViewById(R.id.editText3);

        String gen1Text = gen1.getText().toString();
        String gen2Text = gen2.getText().toString();
        String gen3Text = gen3.getText().toString();

        i.putExtra("gen11", gen1Text);
        i.putExtra("gen22", gen2Text);
        i.putExtra("gen33", gen3Text);

        startActivity(i);
    }
}




