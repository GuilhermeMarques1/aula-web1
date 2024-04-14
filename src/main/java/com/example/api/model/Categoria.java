package com.example.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Nome;
    private String Descricao;

    public String getDescricao() {
        return Descricao;
    }

    public String getNome() {
        return Nome;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
