package com.example.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String NomeCurso;
    public String Detalhes;
    public String Valor;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return NomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        NomeCurso = nomeCurso;
    }

    public String getDetalhes() {
        return Detalhes;
    }

    public void setDetalhes(String detalhes) {
        Detalhes = detalhes;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public Compras(){

    }
    public Compras(String nomeCurso, String detalhes, String valor) {
        this.NomeCurso = nomeCurso;
        this.Detalhes = detalhes;
        this.Valor = valor;
    }
}
