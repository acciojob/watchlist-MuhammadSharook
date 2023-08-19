package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    HashMap<String,ArrayList<String>> w = new HashMap<>();
    public ResponseEntity<String> addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully! " + movie.getMoviename());
    }

    public ResponseEntity<String> addDirector(Director director) {
        movieRepository.addDirector(director);
        return ResponseEntity.ok("Director added successfully! " + director.getDirectorname());
    }

    public ResponseEntity<String> addMovieDirectorPair(String moviename, String directorname) {
//        movieRepository.addMovieDirectorPair(moviename,directorname);
        if(w.containsKey(directorname))
        {
            ArrayList<String> t = w.get(directorname);
            t.add(moviename);
            w.put(directorname,t);
        }
        else {
            ArrayList<String> t = new ArrayList<>();
            t.add(moviename);
            w.put(directorname,t);
        }
        return ResponseEntity.ok("Successfully paired movie " + moviename + " with director " + directorname);
    }

    public ResponseEntity<Movie> getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public ResponseEntity<Director> getDirectorByName(String directorname) {
        return movieRepository.getDirectorByName(directorname);
    }

    public ArrayList<String> getMoviesByDirectorName(String directorname) {
        return w.get(directorname);
    }

    public ResponseEntity<ArrayList<String>> findAllMovies() {
        return movieRepository.findAllMovies();

    }

    public ResponseEntity<String> deleteDirectorByName(String directorname) {
        w.remove(directorname);
        return ResponseEntity.ok("Successfully deleted director " + directorname + " and related movies.");
    }

    public ResponseEntity<String> deleteAllDirectors() {
//        movieRepository.deleteAllDirectors();
        w.clear();
        return ResponseEntity.ok("Successfully deleted all directors and their movies.");
    }
}
