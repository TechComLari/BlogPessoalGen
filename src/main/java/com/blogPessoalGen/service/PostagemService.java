package com.blogPessoalGen.service;


import com.blogPessoalGen.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;
}