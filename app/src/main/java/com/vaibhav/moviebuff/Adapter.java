package com.vaibhav.moviebuff;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    public Adapter(List<movie> movieList) {
        this.movieList = movieList;
        base_url_images = "https://image.tmdb.org/t/p/original";
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        movie movie_info = movieList.get(position);
        holder.title.setBackgroundColor(0);
        holder.title.setText(movie_info.getTitle());
        holder.poster.setBackgroundColor(0);
        String url =  String.format("https://image.tmdb.org/t/p/original%s",movie_info.getPoster_path());
//        Log.e("path",url);
        Picasso.get().load(url).into(holder.poster);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),Movie_Info.class);
                intent.putExtra("Data",movie_info);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) holder.itemView.getContext(),holder.poster,"poster_image");
                holder.itemView.getContext().startActivity(intent, activityOptionsCompat.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView poster;
        public LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            poster = itemView.findViewById(R.id.poster);
            linearLayout = itemView.findViewById(R.id.linearlayout_movie_item);
        }
    }

}