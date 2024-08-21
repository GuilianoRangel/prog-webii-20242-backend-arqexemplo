package br.ueg.progweb2.arqexemplo.validations.impl;

import br.ueg.progweb2.arqexemplo.model.Category;
import br.ueg.progweb2.arqexemplo.model.Task;
import br.ueg.progweb2.arquitetura.validations.IValidations;
import br.ueg.progweb2.arquitetura.validations.ValidationAction;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class TaskMandatoryValidation implements IValidations<Task> {
    @Override
    public void validate(Task data, ValidationAction action) {

    }
}
