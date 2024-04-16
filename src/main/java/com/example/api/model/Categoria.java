package com.example.api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.UniqueConstraint;


@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Nome;
    private String Descricao;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "operacoes_categorias",
      uniqueConstraints = @UniqueConstraint (
      columnNames = {"operacao_id","categoria_id"}, 
      name = "unique_operacao_categoria"
    ), 
    joinColumns = @JoinColumn(name = "categoria_id", 
        referencedColumnName = "id", 
        table = "categoria", 
        unique = false
    ), 
    inverseJoinColumns = @JoinColumn (
        name = "usuario_id", 
        referencedColumnName = "id", 
        table = "usuario", 
        unique = false
    )
    )    
  private List<Operacao> operacoes = new ArrayList<Operacao>();

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
