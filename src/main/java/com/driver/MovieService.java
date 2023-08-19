package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return "Successfully added movie!";
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "Successfully added director!";
    }

    public String addMovieDirectorPair(String moviename, String directorname) {
        movieRepository.addMovieDirectorPair(moviename,directorname);
        return "Successfully paired movie " + moviename + " with director " + directorname;
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String directorname) {
        return movieRepository.getDirectorByName(directorname);
    }

    public ArrayList<String> getMoviesByDirectorName(String directorname) {
        return movieRepository.getMoviesByDirectorName(directorname);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();

    }

    public ResponseEntity<String> deleteDirectorByName(String directorname) {
        movieRepository.deleteDirectorByName(directorname);
        return ResponseEntity.ok("Successfully deleted director " + directorname + " and related movies.");
    }

    public ResponseEntity<String> deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
        return ResponseEntity.ok("Successfully deleted all directors and their movies.");
    }
}
