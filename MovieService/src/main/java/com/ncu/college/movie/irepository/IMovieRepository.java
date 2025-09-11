package com.ncu.college.movie.irepository;

import java.util.List;
import com.ncu.college.movie.model.Movie;

public interface IMovieRepository {


    public List<Movie> GetAllMovies();

    public Movie GetMovieById(String movieId);


    public int AddMovie(Movie movie);
}
