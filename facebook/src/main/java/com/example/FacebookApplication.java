package com.example;

import com.example.facebook.utils.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
@Slf4j
@Transactional
public class FacebookApplication {

    private final SendEmailService sendEmailService;

    public FacebookApplication(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FacebookApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
       sendEmailService.sendEmailWithAttachment(
               "sangary7683@yahoo.com",
               "This is a message with attachment, check below",
               "ADMISSION CONFIRMED",
               "C:\\Users\\sophia\\Pictures\\deer.jpg");
    }
}
