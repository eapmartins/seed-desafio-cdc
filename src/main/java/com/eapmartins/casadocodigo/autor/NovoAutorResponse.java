package com.eapmartins.casadocodigo.autor;

import java.time.Instant;

public class NovoAutorResponse {

    private Long id;
    private Instant criadoEm;

    public NovoAutorResponse(Long id, Instant criadoEm) {
        this.id = id;
        this.criadoEm = criadoEm;
    }

    public Long getId() {
        return id;
    }

    public Instant getCriadoEm() {
        return criadoEm;
    }

    @Override
    public String toString() {
        return "NovoAutorResponse{" +
                "id=" + id +
                ", criadoEm=" + criadoEm +
                '}';
    }
}
