package com.example.myapi;

import com.example.myapi.domain.Usuario;
import com.example.myapi.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class MyApiApplication implements CommandLineRunner {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public MyApiApplication(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null,"Eveliny Muniz","muniz","123");
        Usuario u2 = new Usuario(null,"Emanuel Muniz","muniz01","123");

        usuarioRepository.saveAll(Arrays.asList(u1,u2));

    }
}
