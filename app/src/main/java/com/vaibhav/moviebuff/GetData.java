package com.vaibhav.moviebuff;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetData {

    @GET("movie/popular?api_key=cd5783a235ce5f9b9833825fe0b79f40&language=en-US&page=1")
    Call<MovieResponse> getMovies();

}
