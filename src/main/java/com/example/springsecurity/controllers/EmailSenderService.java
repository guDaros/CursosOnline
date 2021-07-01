package com.example.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("webcursos16@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);


        mailSender.send(message);
        System.out.printf("mail send..");
    }
}
