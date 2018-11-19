package asus.com.modul10_retrofit.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import asus.com.modul10_retrofit.DetailActivity;
import asus.com.modul10_retrofit.Models.Movie;
import asus.com.modul10_retrofit.R;

public class MovieAdapters extends RecyclerView.Adapter<MovieAdapters.MovieViewHolder> {
    private List<Movie> movies;
    private int rowLayout;
    private Context context;
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = v.findViewById(R.id.movies_layout);
            movieTitle = v.findViewById(R.id.title);
            data = v.findViewById(R.id.subtitle);
            movieDescription = v.findViewById(R.id.description);
            rating = v.findViewById(R.id.rating);
        }
    }
    public MovieAdapters(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    @Override
    public MovieAdapters.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),DetailActivity.class);
                i.putExtra("judul",movies.get(position).getTitle());
                i.putExtra("tanggal",movies.get(position).getReleaseDate());
                i.putExtra("deskripsi",movies.get(position).getOverview());
                i.putExtra("rating",movies.get(position).getVoteAverage().toString());
                view.getContext().startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }
}

