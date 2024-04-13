package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.example.api.repository.OperacaoRepository;
import com.example.api.model.Operacao;


@Controller("OperacaoController")
@RequestMapping(value = "/operacao")

public class OperacaoController {
   @Autowired
   private OperacaoRepository operacaoRepository;

   @GetMapping(value="/", produces="application/json")
   public ResponseEntity<List<Operacao>> getAllOperacoes(){
    List<Operacao> operacoes = (List<Operacao>) this.operacaoRepository.findAll();

    return new ResponseEntity(operacoes, HttpStatus.OK);
   }

   @PostMapping(value="/", produces="application/json")
    public ResponseEntity<Operacao> insertNewProduct (@RequestBody Operacao operacao){

        Operacao produtoSalvo = operacaoRepository.save(operacao);

        return new ResponseEntity(produtoSalvo, HttpStatus.OK);
    }    

}
