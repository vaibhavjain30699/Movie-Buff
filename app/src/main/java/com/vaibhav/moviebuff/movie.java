package com.vaibhav.moviebuff;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class movie implements Serializable {

    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("overview")
    String overview;

    @SerializedName("poster_path")
    String poster_path;

    @SerializedName("backdrop_path")
    String backdrop_path;

    @SerializedName("vote_average")
    Float vote_average;

    @SerializedName("release_date")
    String date;

    public movie(int id, String title, String overview, String poster_path, String backdrop_path) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public Float getVote_average() {
        return vote_average;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setVote_average(Float vote_average) {
        this.vote_average = vote_average;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
