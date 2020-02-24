package com.example.movie101.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie101.R;
import com.example.movie101.models.Result;
import com.example.movie101.ui.MovieDisplay;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.movie101.utilities.Constants.POSTER_BASE_URL;

public class adapter2 extends RecyclerView.Adapter<adapter2.MoviesViewHolder>  {
    private List<Result> mMovies;
    private Context mContext;



    public adapter2(List<Result> mMovies, Context  mContext) {
        this.mMovies=mMovies;
        this.mContext=mContext;
    }

    @Override
    public adapter2.MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_movie, parent, false);
        adapter2.MoviesViewHolder viewHolder = new adapter2.MoviesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(adapter2.MoviesViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                v.animate().alpha(0.2f).xBy(-100).yBy(100);

                Intent intent =new Intent(mContext, MovieDisplay.class);
                intent.putExtra("title",mMovies.get(position).getOriginalTitle());
                intent.putExtra("category",mMovies.get(position).getOriginalLanguage());
                intent.putExtra("description",mMovies.get(position).getOverview());
                intent.putExtra("posterPath",mMovies.get(position).getPosterPath());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_poster) ImageView mMovieImageView;
        @BindView(R.id.movie_title) TextView mTitleTextView;
        @BindView(R.id.cardViewId) CardView mCardView;
//        @BindView(R.id.movieSummaryTextView) TextView mOverviewTextView;
//        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindMovie(Result movies) {
            //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(mMovieImageView);
            Picasso.get().load(POSTER_BASE_URL+movies.getPosterPath()).into(mMovieImageView);
            Log.v("rposter path",movies.getPosterPath());
            mTitleTextView.setText(movies.getOriginalTitle());
//            mOverviewTextView.setText(movies.getOverview());
//            mRatingTextView.setText("Rating: " + movies.getVoteAverage() + "/5");
        }
    }
}
