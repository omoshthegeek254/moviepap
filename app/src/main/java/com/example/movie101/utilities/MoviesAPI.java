package com.example.movie101.utilities;

import com.example.movie101.models.TrendingMoviesResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPI {
    @GET("trending/all/day")
    Call<TrendingMoviesResponse> getPopularMovies(@Query("api_key") String myAPIKey);
}
//    @GET("trending/all/day")
//    Call<TrendingMoviesResponse> getMovies(
//
//    );
//}
