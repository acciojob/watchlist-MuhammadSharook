package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie)
    {
        return movieService.addMovie(movie);
    }
    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director)
    {
        return movieService.addDirector(director);
    }
    @PutMapping("/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("name1") String moviename,@RequestParam("name2") String directorname)
    {
        return movieService.addMovieDirectorPair(moviename,directorname);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name") String moviename)
    {
        return movieService.getMovieByName(moviename);
    }
    @GetMapping("/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name") String directorname)
    {
        return movieService.getDirectorByName(directorname);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ArrayList<String> getMoviesByDirectorName(@PathVariable("director") String directorname)
    {
        return movieService.getMoviesByDirectorName(directorname);
    }
    @GetMapping("/get-all-movies")
    public ArrayList<String> findAllMovies()
    {
        return movieService.findAllMovies();
    }
    @DeleteMapping("/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("name") String directorname)
    {
        return movieService.deleteDirectorByName(directorname);
    }
    @DeleteMapping("/delete-all-directors")
    public String deleteAllDirectors()
    {
        return movieService.deleteAllDirectors();
    }
}
