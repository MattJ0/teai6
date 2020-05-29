package com.mattjohnson.teai6.aspect;

import com.mattjohnson.teai6.model.Movie;
import com.mattjohnson.teai6.service.EmailServiceImpl;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PostMovieMailSender {

    @Value("${receiver.mail.adress}")
    private String mailAddress;

    private EmailServiceImpl emailService;
    private MovieMailTemplates movieMailTemplates;


    @Autowired
    public PostMovieMailSender(EmailServiceImpl emailService, MovieMailTemplates movieMailTemplates) {
        this.emailService = emailService;
        this.movieMailTemplates = movieMailTemplates;

    }

    @After("@annotation(PostMovieMail) && args(movie)")
    private void sendEmailAfterAddMovie(Movie movie){
        SimpleMailMessage template = movieMailTemplates.getPostMovieSimpleMessage(movie);
        emailService.sendSimpleMessage(mailAddress,
                template.getSubject(),
                template.getText());
    }
}
