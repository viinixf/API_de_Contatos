package br.com.contatos;

/**
 * Criar classe para contato
 * - id
 * - nome
 * - telefone
 * - idade
 * - sexo (M|F)
 * Vai criar o repositório
 * Vai criar o controller com as operações de get / insert / delete / getAll / getPorNome
 * No postmann tu vai criar o consumo das operações
 * Quando estiver ok me chama. */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContatoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContatoApplication.class, args);
    }
}

