 package com.vaibhav.moviebuff;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

 public class Movie_Info extends AppCompatActivity {

    public movie movie_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        movie_data = (movie) getIntent().getSerializableExtra("Data");

        ImageView poster = findViewById(R.id.poster_movie);
        String url =  String.format("https://image.tmdb.org/t/p/original%s",movie_data.getPoster_path());
        Picasso.get().load(url).into(poster);

        TextView title = findViewById(R.id.title_date);
        String title_text = movie_data.getTitle() + "\n" + movie_data.getVote_average().toString() + "\n" + movie_data.getDate();
        title.setText(title_text);

        TextView overview = findViewById(R.id.overview);
        overview.setText(movie_data.getOverview());

        toolBarLayout.setTitle(movie_data.getTitle());
        if(movie_data.getBackdrop_path()==null){
            url =  String.format("https://image.tmdb.org/t/p/original%s",movie_data.getBackdrop_path());
            Picasso.get().load(url).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    toolBarLayout.setBackground(new BitmapDrawable(getApplicationContext().getResources(),bitmap));
                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });
        }

    }
}