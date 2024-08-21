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
import java.util.Optional;

@Order(2)
@Component
public class StudentDuplicatedRegisterNumberValidation implements IValidations<Student> {
    @Autowired
    protected StudentRepository repository;
    @Override
    public void validate(Student data, ValidationAction action) {
        if(Arrays.asList(
                ValidationAction.CREATE
        ).contains(action) ) {
            Optional<Student> byRegisterNumber = repository.findByRegisterNumber(data.getRegisterNumber());
            if (byRegisterNumber.isPresent()) {
                throw new BusinessLogicException(BusinessLogicError.REGISTER_NUMBER_DUPLICATED);
            }
        }
    }
}
