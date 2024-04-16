package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.api.model.Person;
import com.example.api.model.Usuario;
import com.example.api.repository.UsuarioRepository;

@Controller("IndexController")
@RequestMapping(value = "/usuario")
public class IndexController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Manipulando parâmetros
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Usuario>> getAllOperacoes() {
        List<Usuario> operacoes = (List<Usuario>) this.usuarioRepository.findAll();

        return new ResponseEntity(operacoes, HttpStatus.OK);
    }

    // Retornando objetos
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping(value="/endpoint2", produces="application/json")
    public ResponseEntity init2 (){

        Usuario usuario = new Person();
        usuario.setId(1L);
        usuario.setEmail("user@gmail.com");
        usuario.setSenha("123");

        Usuario usuario2 = new Person();
        usuario2.setId(2L);
        usuario2.setEmail("user2@gmail.com");
        usuario2.setSenha("123");        

        List<Usuario> list = new ArrayList<Usuario>();
        list.add(usuario);
        list.add(usuario2);

        return new ResponseEntity(list, HttpStatus.OK);
    }

    // Retornando registros do BD
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping(value="/endpoint3/{id}", produces="application/json")
    public ResponseEntity<Usuario> init3 (@PathVariable(value="id") Long id){

        try{
            Optional<Usuario> usuario = usuarioRepository.findById(id);
            return new ResponseEntity(usuario.get(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity("no such user", HttpStatus.NOT_FOUND);
        }        
        
    }    

    // Cadastrano usuario
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping(value="/", produces="application/json")
    public ResponseEntity<Usuario> cadastrar (@RequestBody Usuario usuario){    

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new ResponseEntity(usuarioSalvo, HttpStatus.OK);
    }



}