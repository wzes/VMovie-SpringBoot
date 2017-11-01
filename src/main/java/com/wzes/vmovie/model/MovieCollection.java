package com.wzes.vmovie.model;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */

public class MovieCollection {

    private String username;
    private String movieId;

    public MovieCollection(String username, String movieId) {
        this.username = username;
        this.movieId = movieId;
    }

    public MovieCollection() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
