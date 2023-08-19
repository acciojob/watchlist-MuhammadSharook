package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Repository
public class MovieRepository {
    HashMap<String,Movie> m = new HashMap<>();
    HashMap<String,Director> d = new HashMap<>();

    HashMap<String,ArrayList<String>> w = new HashMap<>();

    public void addMovie(Movie movie) {
        m.put(movie.getmoviename(),movie);
    }

    public void addDirector(Director director) {
        d.put(director.getDirectorname(), director);
    }

    public Movie getMovieByName(String moviename) {
        return m.get(moviename);
    }

    public Director getDirectorByName(String directorname) {
        return d.get(directorname);
    }

    public ArrayList<String> findAllMovies() {
        Set<String> stringSet = m.keySet();
        ArrayList<String> pans = new ArrayList<>(stringSet);
        return pans;
    }

}
