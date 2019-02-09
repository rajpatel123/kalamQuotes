package com.mycomputer.kalamnew;
 

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import static android.support.constraint.Constraints.TAG;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
 
    private List<Movie> moviesList;


    private Context context;

    public MoviesAdapter(Context context) {
        this.context = context;
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, year, genre;
        private CardView cardView;

        public MyViewHolder(View view) {//
            super(view);//
            cardView=(CardView) view.findViewById(R.id.card);//


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
        holder.cardView.setTag(position);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                 // Log.d(TAG, "Element at " + getLayoutPosition () + " clicked.");

                  Bundle bundle = new Bundle();
                  //add data to your bundle
                 // bundle.putInt("id", getLayoutPosition());
                  //create intent
                  Intent mainIntent = new Intent(context,MainActivity .class);
                  //add bundle to intent
                  mainIntent.putExtras(bundle);
                  //start activity
                  context.startActivity(mainIntent);
              }





          });
}

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}