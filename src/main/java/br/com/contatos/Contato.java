package br.com.contatos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe Contato (entidade)
 * A Annotation Entity define que essa será a classe entidade;
 *
 * @author fritz
 */
@Entity

public class Contato {

    //Aponta qual campo da entidade representa a chave primária
    @Id
    //O ID é gerado pela coluna de auto incremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Annotation usada para adicionar à coluna o nome na tabela de um banco
    @Column(nullable = false)
    //Nullable -> Define se o campo pode ser nulo ou não
    private String nomeDoContato;
    @Column(nullable = false)
    private String telefoneDoContato;
    @Column(nullable = false)
    private int idadeDoContato;
    @Column(nullable = false)
    private char sexoDoContato;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNomeDoContato(String nomeDoContato) {
        this.nomeDoContato = nomeDoContato;
    }

    public String getNomeDoContato() {
        return nomeDoContato;
    }

    public void setTelefoneDoContato(String telefoneDoContato) {
        this.telefoneDoContato = telefoneDoContato;
    }

    public String getTelefoneDoContato() {
        return telefoneDoContato;
    }

    public void setIdadeDoContato(int idadeDoContato) {
        this.idadeDoContato = idadeDoContato;
    }

    public int getIdadeDoContato() {
        return idadeDoContato;
    }

    public void setSexoDoContato(char sexoDoContato) {
        this.sexoDoContato = sexoDoContato;
    }

    public char getSexoDoContato() {
        return sexoDoContato;
    }

}
