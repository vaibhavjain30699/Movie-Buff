package com.vaibhav.moviebuff;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("results")
    List<movie> movieList;

    public MovieResponse(List<movie> movieList) {
        this.movieList = movieList;
    }

    public List<movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<movie> movieList) {
        this.movieList = movieList;
    }

}
