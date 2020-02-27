package com.example.movie101.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.movie101.R;
import com.example.movie101.adapters.adapter2;
import com.example.movie101.models.Result;
import com.example.movie101.models2.Series;
import com.example.movie101.utilities.Constants;
import com.example.movie101.utilities.MoviesAPI;
import com.example.movie101.utilities.MoviesClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.searchRecyclerView) RecyclerView mRecyclerView;

    private adapter2 mAdapter;

    public List<Result> searchMovielst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
String test ="vikings";



        MoviesAPI client = MoviesClient.getClient();

       // Call<Series> call = client.searchSeries(test, Constants.MOVIE_API_KEY);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }
//executing search
    private void doMySearch(String query) {
        
    }

    //inflate menu search  item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
