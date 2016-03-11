package br.com.consultoria.cadastral.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Genero {

    ACAO("Ação"),
    COMEDIA("Comédia"),
    DRAMA("Drama"),
    LANCAMENTO("Lançamento");

    private final String nome;

    private Genero(String nome) {
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
