package com.example.api.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.api.model.Operacao;

public interface OperacaoRepository extends CrudRepository<Operacao, Long> {

}
