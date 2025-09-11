package com.ncu.college.movie.controller;

import com.ncu.college.movie.dto.MovieDto;
import com.ncu.college.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movies")
@RestController
public class MovieController {

    private final MovieService _movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this._movieService = movieService;
    }


    @GetMapping("/all")
    public List<MovieDto> getAllMovies() {
        return _movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public MovieDto getMovieById(@PathVariable String movieId) {
        return _movieService.getMovieById(movieId);
    }

    @PostMapping("/add")
    public String addMovie(@RequestBody MovieDto movieDto) {
        boolean success = _movieService.addMovie(movieDto);
        return success ? "Movie added successfully" : "Failed to add movie";
    }
}
