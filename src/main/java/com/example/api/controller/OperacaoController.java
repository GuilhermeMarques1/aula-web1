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

import com.example.api.repository.OperacaoRepository;
import com.example.api.model.Operacao;


@Controller("OperacaoController")
@RequestMapping(value = "/operacao")
public class OperacaoController {
   @Autowired
   private OperacaoRepository operacaoRepository;

@SuppressWarnings({ "rawtypes", "unchecked" })
@GetMapping(value="/", produces="application/json")
   public ResponseEntity<List<Operacao>> getAllOperacoes(){
    List<Operacao> operacoes = (List<Operacao>) this.operacaoRepository.findAll();

    return new ResponseEntity(operacoes, HttpStatus.OK);
   }

   @SuppressWarnings({ "unchecked", "rawtypes" })
@PostMapping(value="/", produces="application/json")
    public ResponseEntity<Operacao> insertNewProduct (@RequestBody Operacao operacao){

        Operacao operacaoSalvo = operacaoRepository.save(operacao);

        return new ResponseEntity(operacaoSalvo, HttpStatus.OK);
    }    

}
