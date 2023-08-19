package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String > addMovie(@RequestBody Movie movie)
    {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.OK);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.OK);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name1") String moviename,@RequestParam("name2") String directorname)
    {
        return new ResponseEntity<>(movieService.addMovieDirectorPair(moviename,directorname),HttpStatus.OK);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name)
    {
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorname)
    {
        return new ResponseEntity<>(movieService.getDirectorByName(directorname),HttpStatus.OK);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorname)
    {
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(directorname),HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
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
