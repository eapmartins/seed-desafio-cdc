package com.eapmartins.casadocodigo.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping("/autores")
    public ResponseEntity create(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = request.toEntity();
        entityManager.persist(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new NovoAutorResponse(autor.getId(), autor.getCriadoEm()));
    }
}
