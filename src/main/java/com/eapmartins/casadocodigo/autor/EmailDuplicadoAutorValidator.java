package com.eapmartins.casadocodigo.autor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoAutorValidator implements Validator {

    private final AutorRepository repository;

    public EmailDuplicadoAutorValidator(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors())
            return;

        NovoAutorRequest request = (NovoAutorRequest) target;
        Optional<Autor> autor = repository.findByEmail(request.getEmail());

        if (autor.isPresent())
            errors.reject("email", null, "email já cadastrado");
    }
}
