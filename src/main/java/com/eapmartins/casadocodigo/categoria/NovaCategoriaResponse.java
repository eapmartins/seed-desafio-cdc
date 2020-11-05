package com.eapmartins.casadocodigo.categoria;

import java.time.Instant;

public class NovaCategoriaResponse {

    private Long id;
    private Instant criadoEm = Instant.now();

    public NovaCategoriaResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Instant getCriadoEm() {
        return criadoEm;
    }

    @Override
    public String toString() {
        return "CategoriaResponse{" +
                "id=" + id +
                ", criadoEm=" + criadoEm +
                '}';
    }
}
