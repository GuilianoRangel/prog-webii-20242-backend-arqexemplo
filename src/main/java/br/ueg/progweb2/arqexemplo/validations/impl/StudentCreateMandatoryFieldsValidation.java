package br.ueg.progweb2.arqexemplo.validations.impl;


import br.ueg.progweb2.arqexemplo.model.Student;
import br.ueg.progweb2.arquitetura.exceptions.BusinessLogicError;
import br.ueg.progweb2.arquitetura.exceptions.BusinessLogicException;
import br.ueg.progweb2.arquitetura.validations.IValidations;
import br.ueg.progweb2.arquitetura.validations.ValidationAction;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Order(1000)
@Component
public class StudentCreateMandatoryFieldsValidation implements IValidations<Student> {

    @Override
    public void validate(Student data, ValidationAction action) {
        if(Objects.equals(ValidationAction.CREATE, action)) {
            if(Strings.isEmpty(data.getRegisterNumber()) ){
                throw new BusinessLogicException(BusinessLogicError.MANDATORY_FIELD_NOT_FOUND);
            }
        }
    }
}
