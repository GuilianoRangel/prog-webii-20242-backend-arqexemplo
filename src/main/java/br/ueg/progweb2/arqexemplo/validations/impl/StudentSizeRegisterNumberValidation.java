package br.ueg.progweb2.arqexemplo.validations.impl;

import br.ueg.progweb2.arqexemplo.model.Student;
import br.ueg.progweb2.arqexemplo.repository.StudentRepository;

import br.ueg.progweb2.arquitetura.exceptions.BusinessLogicError;
import br.ueg.progweb2.arquitetura.exceptions.BusinessLogicException;
import br.ueg.progweb2.arquitetura.validations.IValidations;
import br.ueg.progweb2.arquitetura.validations.ValidationAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1001)
@Component
public class StudentSizeRegisterNumberValidation implements IValidations<Student> {
    @Autowired
    protected StudentRepository repository;
    @Override
    public void validate(Student data, ValidationAction action) {
        if(Arrays.asList(
                ValidationAction.CREATE
        ).contains(action) ) {
            if(data.getRegisterNumber().length()>5){
                throw new BusinessLogicException(BusinessLogicError.REGISTER_NUMBER_INVALID);
            }
        }
    }
}
