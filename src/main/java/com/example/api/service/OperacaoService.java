package com.example.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.api.model.Operacao;
import com.example.api.repository.OperacaoRepository;

@Service
public class OperacaoService {
    @Autowired
    private OperacaoRepository operacaoRepository;

    @Override
    public UserDetails loadOperacaoById(Long id) throws UsernameNotFoundException {
        return (UserDetails) operacaoRepository.findById(id);
    }
    
    public Operacao loadOperacaoByDate(LocalDateTime date){
        return operacaoRepository.findByDate(date);
    }
    
    public Operacao loadOperacaoByCategoria(String categoria){
        return operacaoRepository.findByDate(categoria);
    }

    public Operacao loadOperacoesGroupedByCategoria(){
        return operacaoRepository.GroupByCategoria();
    }


}
