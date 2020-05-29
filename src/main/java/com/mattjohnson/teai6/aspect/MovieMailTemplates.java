package com.mattjohnson.teai6.aspect;

import com.mattjohnson.teai6.model.Movie;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

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
}
