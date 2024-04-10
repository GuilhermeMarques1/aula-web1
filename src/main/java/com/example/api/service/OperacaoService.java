package com.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.api.repository.OperacaoRepository;

@Service
public class OperacaoService {
    @Autowired
    private OperacaoRepository operacaoRepository;

    @Override
    public UserDetails loadOperacaoById(Long id) throws UsernameNotFoundException {
        return operacaoRepository.findById(id);
    }   
}
