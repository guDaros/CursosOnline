package com.example.springsecurity;

import com.example.springsecurity.model.Compras;
import com.example.springsecurity.model.Moeda;
import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.ComprasRepository;
import com.example.springsecurity.repository.MoedaRepository;
import com.example.springsecurity.repository.RoleRepository;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    ComprasRepository comprasRepository;
    @Autowired
    MoedaRepository MoedaComprasRepository;


    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("admin@code.com", passwordEncoder.encode("senha"),"Davi", "Custodio", true, "davi", "Dolar");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        user = new User("user@code.com", passwordEncoder.encode("senha"),"gustavo", "daros", true, "gustavo","Real" );
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        Compras compras = new Compras("Curso Html","Curso html completo","50,00");
        comprasRepository.save(compras);

        Compras compras2 = new Compras("Curso C#","Curso C# completo","150,00");
        comprasRepository.save(compras2);

        Moeda moeda = new Moeda("Dolar", (float) 5.01);
        MoedaComprasRepository.save(moeda);

        Moeda moeda2 = new Moeda("Euro", (float) 5.92);
        MoedaComprasRepository.save(moeda2);

        Moeda moeda3 = new Moeda("Real", (float) 1);
        MoedaComprasRepository.save(moeda3);
    }
}
