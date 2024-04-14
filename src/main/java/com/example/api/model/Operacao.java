
package com.example.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Operacao {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;
  private String descricao;

  @SuppressWarnings("removal")
  @org.hibernate.annotations.ForeignKey(name="usuario_id")
  @ManyToOne(optional = false)      // Define o tipo da relação.
  @JsonIgnore
  private Usuario usuario;

  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name = "operacoes_categorias", 
      uniqueConstraints = @UniqueConstraint (
      columnNames = {"operacao_id","categoria_id"}, 
      name = "unique_operacao_categoria"
  ), 
  joinColumns = @JoinColumn(name = "operacao_id", 
      referencedColumnName = "id", 
      table = "operacao", 
      unique = false
  ), 
  inverseJoinColumns = @JoinColumn (
      name = "categoria_id", 
      referencedColumnName = "id", 
      table = "categoria", 
      unique = false
  )
)    
  private List<Categoria> categorias = new ArrayList<Categoria>();

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
