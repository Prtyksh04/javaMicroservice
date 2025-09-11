package com.ncu.college.movie.dto;

public class MovieDto {
    public String movieId;
    public String title;
    public String language;

    public MovieDto() {
    }

    public MovieDto(String movieId, String title, String language) {
        this.movieId = movieId;
        this.title = title;
        this.language = language;
    }

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
