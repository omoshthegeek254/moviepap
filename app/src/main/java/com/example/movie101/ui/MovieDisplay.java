package com.example.movie101.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie101.R;
import com.squareup.picasso.Picasso;

import static com.example.movie101.utilities.Constants.POSTER_BASE_URL;

public class MovieDisplay extends AppCompatActivity {
    private  TextView mTitle,mCategory,mDescription;
    private ImageView mPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_display);
        mTitle = findViewById(R.id.mTitle);
        mCategory= findViewById(R.id.mCategory);
        mDescription=findViewById(R.id.mDescription);
        mPoster=findViewById(R.id.mPosterId);

//receiving intent data
        Intent intent =getIntent();
        String title = intent.getStringExtra("title");
        String category = intent.getStringExtra("category");
        String posterPath = intent.getStringExtra("posterPath");
        String description = intent.getStringExtra("description");


        //setting data on view
        mTitle.setText(title);
        mCategory.setText(category);
        mDescription.setText(description);
        Picasso.get().load(POSTER_BASE_URL+posterPath).into(mPoster);


    }
    //inflate menu search
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
