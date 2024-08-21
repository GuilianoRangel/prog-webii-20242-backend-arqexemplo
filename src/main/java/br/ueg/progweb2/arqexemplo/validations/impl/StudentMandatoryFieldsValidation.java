package br.ueg.progweb2.arqexemplo.validations.impl;


import br.ueg.progweb2.arqexemplo.model.Student;
import br.ueg.progweb2.arqexemplo.repository.StudentRepository;
import br.ueg.progweb2.arquitetura.exceptions.MandatoryException;
import br.ueg.progweb2.arquitetura.validations.IValidations;
import br.ueg.progweb2.arquitetura.validations.ValidationAction;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Order(0)
@Component
public class StudentMandatoryFieldsValidation implements IValidations<Student> {
    @Autowired
    protected StudentRepository repository;
    @Override
    public void validate(Student data, ValidationAction action) {
        if(Objects.equals(ValidationAction.GENERAL_MANDATORY, action)){
            if(
                    Strings.isEmpty(data.getName())
            ){
                throw new MandatoryException("Campos obrigatórios não preenchidos");
            }
        }
    }
}
