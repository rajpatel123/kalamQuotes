package com.mycomputer.kalamnew;
 
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
 
import java.util.List;
 
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
 
    private List<Movie> moviesList;
 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
 
        public MyViewHolder(View view) {
            super(view);


        }
    }
 
 
    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);

    }
 
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}