package com.example.movie101.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.movie101.R;
import com.example.movie101.adapters.MoviesListAdapter;
import com.example.movie101.models.Result;
import com.example.movie101.models.TrendingMoviesResponse;
import com.example.movie101.utilities.Constants;
import com.example.movie101.utilities.MoviesAPI;
import com.example.movie101.utilities.MoviesClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private MoviesListAdapter mAdapter;

    public List<Result> trendingMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);


        MoviesAPI client = MoviesClient.getClient();

        Call<TrendingMoviesResponse> call = client.getPopularMovies(Constants.MOVIE_API_KEY);
        Log.v("MY URL",String.valueOf(call.request().url()));

        call.enqueue(new Callback<TrendingMoviesResponse>() {
            @Override
            public void onResponse(Call<TrendingMoviesResponse> call, Response<TrendingMoviesResponse> response) {

                if(response.isSuccessful()&& response.body().getResults() !=null){
                  //what to do if successful
                    trendingMoviesList = response.body().getResults();

                    mAdapter = new MoviesListAdapter(trendingMoviesList,MoviesActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MoviesActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                }
                else {
                    Toast.makeText(MoviesActivity.this, "API11 call unsuccessful...Please try later!", Toast.LENGTH_SHORT).show();

                }








            }

            @Override
            public void onFailure(Call<TrendingMoviesResponse> call, Throwable t) {
                Toast.makeText(MoviesActivity.this, "Something went wrong22...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }

//    public void getCurrentPopularMovies(List<Result> movies) {
//        recyclerView = findViewById(R.id.popularRecyclerView);
//        adapter = new PopularMoviesAdapter(this,movies);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//    }



}
