package com.example.springsecurity.controllers;

import com.example.springsecurity.model.*;
import com.example.springsecurity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    ComprasRepository comprasRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    comunidadeRepository comunidadeRepository;

    @RequestMapping("/login")
    public String login(){
        return"login";
    }

    @RequestMapping("/")
    public String index(){
        return "redirect:/home";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }
    @RequestMapping("/home")
    public String home(Model model)
    {
        return "home";
    }

    @RequestMapping("/blog")
    public String blog(){
        return "blog";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/lista")
    public String lista(){
        return "lista";
    }


    @RequestMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("user", new User());
        return "cadastrar";
    }

    @PostMapping("/saveUser")
    public String processForm(@Valid User user){
        roleRepository.save(new Role(user.getUsername()));
        userRepository.save(user);
        return "redirect:/lista";
    }

    @RequestMapping("/meuscursos")
    public String meuscusos(Model model)
    {
        model.addAttribute("Compras", itemsRepository.findAll());
        model.addAttribute("senha", new Security());
        return "meuscursos";
    }

    @RequestMapping("/detalhesCursoHtml")
    public String detalhesCursoHtml(Model model)
    {
        model.addAttribute("compra", comprasRepository.findById(5L));
        return "detalhesCursoHtml";
    }

    @PostMapping("/savehtml")
    public String savehtml(@Valid ItensComprados itensComprados){
        itemsRepository.save(itensComprados);
        return "redirect:/meuscursos";
    }

    @RequestMapping("/detalhesCursoCSharp")
    public String detalhesCursoCSharp(Model model)
    {
        model.addAttribute("compra", comprasRepository.findById(6L));
        return "detalhesCursoCSharp";
    }

    @PostMapping("/saveCSharp")
    public String saveCSharp(@Valid ItensComprados itensComprados){
        itemsRepository.save(itensComprados);
        return "redirect:/meuscursos";
    }

    @RequestMapping("/listaComunidade")
    public String listaComunidade(Model model){
        model.addAttribute("curso", new CursoComunidade());
        model.addAttribute("cursoLista", comunidadeRepository.findAll());
        return "listaComunidade";
    }

    @PostMapping("/salvarCurso")
    public String salvarCurso(@Valid CursoComunidade curso){
        comunidadeRepository.save(curso);
        return "redirect:/listaComunidade";
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword(Model model){
        model.addAttribute("email", new User());

        return "forgotPassword";
    }

    @Autowired
    private EmailSenderService service;

    @PostMapping("/sendEmail")
    public String sendEmail(Mail mail){
        User user = new User();
        service.sendSimpleEmail(mail.getEmail(),
                "Sua nova senha é '123'",
                "Requisição de sua nova senha webCursos");

        userRepository.findByEmail(mail.getEmail());
        user.setId(4l);
        user.setEnabled(true);
        user.setLast_name("daros");
        user.setMoedaPagamento("Real");
        user.setName("gustavo");
        user.setPassword("123");
        user.setUsername("gustavo");
        user.setEmail(mail.getEmail());

        userRepository.save(user);

        return "redirect:/login";
    }

    @PostMapping("/changeSenha")
    public String changeSenha(@Valid Security security){

        if (security.senha1 == security.senha2){

            User user = new User();

            user.setId(4l);
            user.setEnabled(true);
            user.setLast_name("daros");
            user.setMoedaPagamento("Real");
            user.setName("gustavo");
            user.setPassword(security.senha1);
            user.setUsername("gustavo");
            user.setEmail("gustavo.daros16@gmail.com");
            userRepository.save(user);
        }
        return "redirect:/meuscursos";
    }
}
