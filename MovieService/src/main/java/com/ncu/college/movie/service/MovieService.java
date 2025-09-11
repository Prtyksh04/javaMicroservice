package com.ncu.college.movie.service;

import com.ncu.college.movie.dto.MovieDto;
import com.ncu.college.movie.irepository.IMovieRepository;
import com.ncu.college.movie.model.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "MovieService")
public class MovieService {

    private final IMovieRepository _movieRepository;
    private final ModelMapper _modelMapper;

    @Autowired
    public MovieService(IMovieRepository movieRepository, ModelMapper modelMapper) {
        this._movieRepository = movieRepository;
        this._modelMapper = modelMapper;
    }

    public List<MovieDto> getAllMovies() {
        List<Movie> movies = _movieRepository.GetAllMovies();
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie m : movies) {
            MovieDto dto = _modelMapper.map(m, MovieDto.class);
            movieDtos.add(dto);
        }

        return movieDtos;
    }

    public MovieDto getMovieById(String movieId) {
        Movie movie = _movieRepository.GetMovieById(movieId);
        if (movie == null) {
            return null; // or throw custom exception
        }
        return _modelMapper.map(movie, MovieDto.class);
    }

    public boolean addMovie(MovieDto movieDto) {
        try {
            Movie movie = _modelMapper.map(movieDto, Movie.class);
            int rows = _movieRepository.AddMovie(movie);
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error in service addMovie: " + e.getMessage());
            return false;
        }
    }
}
