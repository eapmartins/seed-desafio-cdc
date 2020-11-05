package com.eapmartins.casadocodigo.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class CategoriaController {

    private final CategoriaDuplicadaValidator categoriaDuplicadaValidator;

    @PersistenceContext
    private EntityManager entityManager;

    public CategoriaController(CategoriaDuplicadaValidator categoriaDuplicadaValidator) {
        this.categoriaDuplicadaValidator = categoriaDuplicadaValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(categoriaDuplicadaValidator);
    }

    @Transactional
    @PostMapping("categorias")
    public ResponseEntity create(@RequestBody @Valid NovaCategoriaRequest request) {
        Categoria categoria = request.toEntity();
        entityManager.persist(categoria);
        return ResponseEntity.status(CREATED).body(new NovaCategoriaResponse(categoria.getId()));
    }
}
