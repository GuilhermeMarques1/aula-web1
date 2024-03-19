package com.example.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
