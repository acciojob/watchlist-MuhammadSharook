package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    HashMap<String,ArrayList<String>> w = new HashMap<>();
    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return "Movie added successfully. ";
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "Director added successfully. ";
    }

    public String addMovieDirectorPair(String moviename, String directorname) {
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
        return "Both paired successfully. ";
    }

    public Movie getMovieByName(String moviename) {
        return movieRepository.getMovieByName(moviename);
    }

    public Director getDirectorByName(String directorname) {
        return movieRepository.getDirectorByName(directorname);
    }

    public ArrayList<String> getMoviesByDirectorName(String directorname) {
        return w.get(directorname);
    }

    public ArrayList<String> findAllMovies() {
        return movieRepository.findAllMovies();

    }

    public String deleteDirectorByName(String directorname) {
        w.remove(directorname);
        return "Director and their movies deleted successfully.";
    }

    public String deleteAllDirectors() {
//        movieRepository.deleteAllDirectors();
        w.clear();
        return "All directors and their movies deleted successfully.";
    }
}
