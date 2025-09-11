package com.ncu.college.movie.repository;

import org.springframework.jdbc.core.RowMapper;
import com.ncu.college.movie.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        if (rs == null) {
            return null;
        }

        Movie movie = new Movie();
        movie.setMovieId(rs.getString("movie_id"));   // maps to column movie_id
        movie.setTitle(rs.getString("title"));        // maps to column title
        movie.setLanguage(rs.getString("language"));  // maps to column language

        return movie;
    }
}
