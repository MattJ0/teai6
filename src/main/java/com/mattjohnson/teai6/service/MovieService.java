package com.mattjohnson.teai6.service;

import com.mattjohnson.teai6.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findMovies();

    boolean addMovie(Movie movie);
}
