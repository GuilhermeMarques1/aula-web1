package com.example.api.model;

public class Categoria {
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
