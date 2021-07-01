package com.example.springsecurity;

import com.example.springsecurity.controllers.EmailSenderService;
import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringSecurityApplication {

    @Autowired
    private EmailSenderService service;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void teste(String nome, String email){
//
//
//        User user = null;
//        nome="gustavo";
//        email="teste";
//
//        userRepository.findByUsername(nome);
//
//        String nome1 = user.getEmail();
//        String username = user.getUsername();
//        String senha = user.getPassword();
//        Long Id = user.getId();
//    }

//    public void triggerMail(){
//        service.sendSimpleEmail("gustavo.daros16@gmail.com",
//                "Sua nova senha é 'Senha'",
//                "Requisição de nova senha webCursos");
//    }
}
