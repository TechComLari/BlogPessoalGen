package com.blogPessoalGen.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import com.blogPessoalGen.BlogPessoalGenApplicationTests;
import com.blogPessoalGen.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.blogPessoalGen.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start(){

        usuarioRepository.deleteAll();

        usuarioRepository.save(new Usuario(0L, "Zuma Brito", "zuma@email.com", "13465278", "https://i.imgur.com/FETvs2O.jpg"));

        usuarioRepository.save(new Usuario(0L, "Maya Soares", "maya@email.com", "13465278", "https://i.imgur.com/NtyGneo.jpg"));

        usuarioRepository.save(new Usuario(0L, "Katie Brito", "katie@email.com", "13465278", "https://i.imgur.com/mB3VM2N.jpg"));

        usuarioRepository.save(new Usuario(0L, "Larissa Coutinho", "larissa@email.com", "13465278", "https://i.imgur.com/JR7kUFU.jpg"));

    }

    @Test
    @DisplayName("Retorna 1 usuario por email")
    public void deveRetornarUmUsuario() {

        Optional<Usuario> usuario = usuarioRepository.findByUsuario("maya@email.com");

        assertTrue(usuario.get().getUsuario().equals("maya@email.com"));
    }

    @Test
    @DisplayName("Retorna 3 usuarios por sobrenome")
    public void deveRetornarTresUsuarios() {

        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Brito");

        assertEquals(3, listaDeUsuarios.size());

        assertTrue(listaDeUsuarios.get(0).getNome().equals("Zuma Brito"));
        assertTrue(listaDeUsuarios.get(1).getNome().equals("Maya Brito"));
        assertTrue(listaDeUsuarios.get(2).getNome().equals("Katie Brito"));

    }

    @AfterAll
    public void end() {
        usuarioRepository.deleteAll();
    }

}