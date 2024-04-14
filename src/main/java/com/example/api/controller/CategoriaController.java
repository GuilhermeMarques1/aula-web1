package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.example.api.repository.CategoriaRepository;
import com.example.api.model.Categoria;


@Controller("CategoriaController")
@RequestMapping(value = "/categoria")
public class CategoriaController {
    @Autowired
   private CategoriaRepository categoriaRepository;

   @GetMapping(value="/Categoria", produces="application/json")
   public ResponseEntity<List<Categoria>> getAllOperacoes(){
    List<Categoria> operacoes = (List<Categoria>) this.categoriaRepository.findAll();

    return new ResponseEntity(operacoes, HttpStatus.OK);
   }

   @PostMapping(value="/", produces="application/json")
    public ResponseEntity<Categoria> insertNewProduct (@RequestBody Categoria categoria){

        Categoria categoriaSalva = categoriaRepository.save(categoria);

        return new ResponseEntity(categoriaSalva, HttpStatus.OK);
    }    
}
