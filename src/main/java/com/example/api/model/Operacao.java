
package com.example.api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Operacao {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;
  private String descricao;

  public long getId() {
    return id;
  }

  public String getNome(){
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setId(String nome) {
    this.nome = nome;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
