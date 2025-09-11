package com.ncu.college.movie.model;

public class Movie {
    String movieId;
    String title;
    String language;

    // Default constructor
    public Movie() {
    }

    // Parameterized constructor
    public Movie(String movieId, String title, String language) {
        this.movieId = movieId;
        this.title = title;
        this.language = language;
    }

    // Getters and Setters
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
