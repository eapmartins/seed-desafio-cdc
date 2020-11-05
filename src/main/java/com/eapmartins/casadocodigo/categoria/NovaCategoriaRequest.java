package com.eapmartins.casadocodigo.categoria;

import com.eapmartins.casadocodigo.autor.Autor;
import com.eapmartins.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public NovaCategoriaRequest() {
    }

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toEntity() {
        return new Categoria(this.nome);
    }

    @Override
    public String toString() {
        return "CategoriaRequest{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
