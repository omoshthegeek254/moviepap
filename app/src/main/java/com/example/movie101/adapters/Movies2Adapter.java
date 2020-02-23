package com.example.movie101.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie101.R;
import com.example.movie101.models.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.movie101.utilities.Constants.POSTER_BASE_URL;

public class Movies2Adapter extends RecyclerView.Adapter<Movies2Adapter.MoviesViewHolder> {

    private List<Result> mMovies;
    private Context mContext;

    public Movies2Adapter(List<Result> mMovies, Context  mContext) {
        this.mMovies=mMovies;
        this.mContext=mContext;
    }





    @Override
    public MoviesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_movie, parent, false);
        Movies2Adapter.MoviesViewHolder viewHolder = new Movies2Adapter.MoviesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( MoviesViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));

    }

    @Override
    public int getItemCount()  {
        return mMovies.size();
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_poster) ImageView mMovieImageView;
        @BindView(R.id.movie_title) TextView mTitleTextView;
        private Context mContext;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

//        public MoviesViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }


        public void bindMovie(Result movies) {
            //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(mMovieImageView);
            Picasso.get().load(POSTER_BASE_URL+movies.getPosterPath()).into(mMovieImageView);
            Log.v("poster path",movies.getPosterPath());
            mTitleTextView.setText(movies.getOriginalTitle());
//            mOverviewTextView.setText(movies.getOverview());
//            mRatingTextView.setText("Rating: " + movies.getVoteAverage() + "/5");
        }
    }
    }

