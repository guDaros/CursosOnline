package com.example.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moeda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String moedaNome;
    public float Valor;

    public Moeda() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMoedaNome() {
        return moedaNome;
    }

    public void setMoedaNome(String moedaNome) {
        this.moedaNome = moedaNome;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float valor) {
        Valor = valor;
    }

    public Moeda(String moedaNome, float valor) {
        this.moedaNome = moedaNome;
        Valor = valor;
    }
}
