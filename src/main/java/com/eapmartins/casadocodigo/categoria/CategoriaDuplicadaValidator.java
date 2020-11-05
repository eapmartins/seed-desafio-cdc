package com.eapmartins.casadocodigo.categoria;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaDuplicadaValidator implements Validator {

    private final CategoriaRepository repository;

    public CategoriaDuplicadaValidator(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors())
            return;

        NovaCategoriaRequest request = (NovaCategoriaRequest) target;

        Optional<Categoria> categoria = repository.findByNome(request.getNome());

        if (categoria.isPresent())
            errors.rejectValue("nome", null, "categoria já cadastrada");
    }
}
