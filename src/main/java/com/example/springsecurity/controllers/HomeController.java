package com.example.springsecurity.controllers;

import com.example.springsecurity.model.Compras;
import com.example.springsecurity.model.ItensComprados;
import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.ComprasRepository;
import com.example.springsecurity.repository.ItemsRepository;
import com.example.springsecurity.repository.RoleRepository;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;


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
}
