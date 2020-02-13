package com.example.movie101.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.movie101.R;
import com.example.movie101.models.Result;
import com.example.movie101.ui.MoviesActivity;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesViewHolder> {
        private List<Result> mMovies;
        private Context mContext;



    public MoviesListAdapter(List<Result> mMovies, Context  mContext) {
        this.mMovies=mMovies;
        this.mContext=mContext;
    }

    @Override
        public MoviesListAdapter.MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rest_sample, parent, false);
            MoviesViewHolder viewHolder = new MoviesViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MoviesListAdapter.MoviesViewHolder holder, int position) {
            holder.bindMovie(mMovies.get(position));
        }

        @Override
        public int getItemCount() {
            return mMovies.size();
        }

        public class MoviesViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.movieImageView) ImageView mMovieImageView;
            @BindView(R.id.movieTitleNameTextView) TextView mTitleTextView;
            @BindView(R.id.movieSummaryTextView) TextView mOverviewTextView;
            @BindView(R.id.ratingTextView) TextView mRatingTextView;
            private Context mContext;

            public MoviesViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                mContext = itemView.getContext();
            }

            public void bindMovie(Result movies) {
                mTitleTextView.setText(movies.getName());
                mOverviewTextView.setText(movies.getOverview());
                mRatingTextView.setText("Rating: " + movies.getVoteAverage() + "/5");
            }
        }
    }
