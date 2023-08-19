package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String > addMovie(@RequestBody Movie movie)
    {
        return movieService.addMovie(movie);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        return movieService.addDirector(director);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name1") String moviename,@RequestParam("name2") String directorname)
    {
        return movieService.addMovieDirectorPair(moviename,directorname);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name)
    {
        return movieService.getMovieByName(name);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorname)
    {
        return movieService.getDirectorByName(directorname);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ArrayList<String> getMoviesByDirectorName(@PathVariable("director") String directorname)
    {
        return movieService.getMoviesByDirectorName(directorname);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<ArrayList<String>> findAllMovies()
    {
        return movieService.findAllMovies();
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String directorname)
    {
        return movieService.deleteDirectorByName(directorname);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        return movieService.deleteAllDirectors();
    }
}
