package com.mattjohnson.teai6.aspect;

import com.mattjohnson.teai6.model.Movie;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMailTemplates {

    public SimpleMailMessage getPostMovieSimpleMessage(Movie movie) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("New movie was added");
        message.setText(
                "New movie was added to the list.\n\n"
        + "Title: " + movie.getTitle() + "\n"
        + "Year: " + movie.getYear() + "\n"
        + "Producer: " + movie.getTitle() + "\n\n"
        + "Don't miss it!");
        return message;
    }

    public SimpleMailMessage getAllMoviesSimpleMessage(List<Movie> movieList) {
        SimpleMailMessage message = new SimpleMailMessage();
        StringBuilder movieListText = new StringBuilder();

        movieList.forEach(movie -> movieListText.append(movie.getTitle()).append("\n"));

        message.setSubject("Movies list");
        message.setText(movieListText.toString());

        return  message;
    }
}
