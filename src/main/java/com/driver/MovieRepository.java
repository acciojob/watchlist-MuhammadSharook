package com.driver;

import org.springframework.http.ResponseEntity;
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
        String m_name = movie.getMoviename();
        m.put(m_name,movie);
    }

    public void addDirector(Director director) {
        d.put(director.getDirectorname(), director);
    }

    public ResponseEntity<Movie> getMovieByName(String name) {
        Movie A = m.get(name);
        return (ResponseEntity<Movie>)  ResponseEntity.ok(A);
    }

    public ResponseEntity<Director> getDirectorByName(String directorname) {
        Director B = d.get(directorname);
        return (ResponseEntity<Director>) ResponseEntity.ok(B);
    }

    public ResponseEntity<ArrayList<String>> findAllMovies() {
        Set<String> stringSet = m.keySet();
        ArrayList<String> pans = new ArrayList<>(stringSet);
        return ResponseEntity.ok(pans);
    }

}
