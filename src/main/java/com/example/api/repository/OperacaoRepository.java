package com.example.api.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.api.model.Operacao;

public interface OperacaoRepository extends CrudRepository<Operacao, Long> {
    @Query("select o from Operacao o where o.id = ?1")
	Operacao findById(Long id);


    @Query("select o from Operacao o join OpUnica ouni join OpRecorrente orc where ouni.data = ?1 OR orc.data = ?1")
    Operacao findByDate();
}
