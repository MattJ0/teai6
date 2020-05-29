package com.mattjohnson.teai6.service;

import com.mattjohnson.teai6.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private List<Movie> movieList;

    public MovieServiceImpl() {
        this.movieList = new ArrayList<>();
    }

    @Override
    public List<Movie> findMovies() {
        return movieList;
    }

    @Override
    public boolean addMovie(Movie movie) {
        return movieList.add(movie);
    }
}
