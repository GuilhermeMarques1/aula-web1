package com.example.api.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OpUnica extends Operacao {
    private float valor;
    private LocalDateTime data;

    public float getValor(){
        return valor;
    }

    public LocalDateTime getData(){
        return data;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }
}