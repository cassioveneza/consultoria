package br.com.consultoria.cadastral.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sexo {

    MASCULINO("Masculino"), 
    FEMININO("Feminino");

    private final String nome;

    private Sexo(String nome) {
        this.nome = nome;
    }

    @JsonValue
    public String getDescription() {
        return toString();
    }
    
    public String getNome() {
        return this.nome;
    }

}
