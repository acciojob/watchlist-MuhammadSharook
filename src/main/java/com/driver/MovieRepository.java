package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Repository
public class MovieRepository {
    HashMap<String,Movie> m = new HashMap<>();
    HashMap<String,Director> d = new HashMap<>();

    HashMap<String,ArrayList<String>> w = new HashMap<>();

    public void addMovie(Movie movie) {
        m.put(movie.getName(),movie);

    }

    public void addDirector(Director director) {
        d.put(director.getName(), director);
    }

    public Movie getMovieByName(String name) {
        return m.get(name);
    }

    public Director getDirectorByName(String directorname) {
        return d.get(directorname);
    }

    public ArrayList<String> getMoviesByDirectorName(String directorname) {
        return w.get(directorname);
    }

    public List<String> findAllMovies() {
        Set<String> stringSet = m.keySet();
        ArrayList<String> pans = new ArrayList<>(stringSet);
        return pans;
    }

    public void deleteDirectorByName(String directorname) {
        for(String movies : w.get(directorname))
        {
            m.remove(movies);
        }
        w.remove(directorname);
        d.remove(directorname);
    }

    public void addMovieDirectorPair(String moviename, String directorname) {
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
    }

    public void deleteAllDirectors() {
        for(String director : d.keySet())
        {
            for(String movies : w.get(director))
            {
                m.remove(movies);
            }
            w.remove(director);
        }
        d.clear();
    }
}

