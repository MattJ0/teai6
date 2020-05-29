package com.mattjohnson.teai6.aspect;

import com.mattjohnson.teai6.model.Movie;
import com.mattjohnson.teai6.service.EmailServiceImpl;
import com.mattjohnson.teai6.service.MovieServiceImpl;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MovieMailSender {

    @Value("${receiver.mail.adress}")
    private String mailAddress;

    private EmailServiceImpl emailService;
    private MovieMailTemplates movieMailTemplates;
    private MovieServiceImpl movieService;


    @Autowired
    public MovieMailSender(EmailServiceImpl emailService, MovieMailTemplates movieMailTemplates,
                           MovieServiceImpl movieService) {
        this.emailService = emailService;
        this.movieMailTemplates = movieMailTemplates;
        this.movieService = movieService;
    }

    @After("@annotation(PostMovieMail) && args(movie)")
    private void sendEmailAfterAddMovie(Movie movie){
        SimpleMailMessage template = movieMailTemplates.getPostMovieSimpleMessage(movie);
        emailService.sendSimpleMessage(mailAddress,
                template.getSubject(),
                template.getText());
    }

    @Scheduled(cron = "0 * * ? * *")
    private void sendMovieList() {
        SimpleMailMessage template = movieMailTemplates.getAllMoviesSimpleMessage(movieService.findMovies());
        emailService.sendSimpleMessage(mailAddress,
                template.getSubject(),
                template.getText());
    }

}
