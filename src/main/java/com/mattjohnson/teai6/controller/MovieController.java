package com.mattjohnson.teai6.controller;

import com.mattjohnson.teai6.aspect.PostMovieMail;
import com.mattjohnson.teai6.model.Movie;
import com.mattjohnson.teai6.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.findMovies(), HttpStatus.OK);
    }

    @PostMovieMail
    @PostMapping
    public ResponseEntity postMovie(@Validated @RequestBody Movie movie) {
        boolean add = movieService.addMovie(movie);
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }

        return new ResponseEntity("item not added" ,HttpStatus.BAD_REQUEST);
    }
}
