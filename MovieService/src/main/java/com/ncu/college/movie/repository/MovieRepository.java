package com.ncu.college.movie.repository;

import java.util.List;
import com.ncu.college.movie.repository.MovieRowMapper;
import com.ncu.college.movie.irepository.IMovieRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ncu.college.movie.model.Movie;

@Repository(value = "MovieRepository")
public class MovieRepository implements IMovieRepository {

    JdbcTemplate _jdbcTemplate;

    @Autowired
    MovieRepository(JdbcTemplate jdbcTemplate) {
        this._jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> GetAllMovies() {
        List<Movie> movies;
        String sql = "SELECT * FROM movies";

        try {
            movies = _jdbcTemplate.query(sql, new MovieRowMapper());
            return movies;
        } catch (Exception e) {
            System.out.println("Error fetching movies: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Movie GetMovieById(String movieId) {
        String sql = "SELECT * FROM movies WHERE movie_id = ?";
        try {
            return _jdbcTemplate.queryForObject(sql, new Object[]{movieId}, new MovieRowMapper());
        } catch (Exception e) {
            System.out.println("Error fetching movie by id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int AddMovie(Movie movie) {
        String sql = "INSERT INTO movies (movie_id, title, language) VALUES (?, ?, ?)";
        try {
            return _jdbcTemplate.update(sql, movie.getMovieId(), movie.getTitle(), movie.getLanguage());
        } catch (Exception e) {
            System.out.println("Error adding movie: " + e.getMessage());
            return 0;
        }
    }
}
