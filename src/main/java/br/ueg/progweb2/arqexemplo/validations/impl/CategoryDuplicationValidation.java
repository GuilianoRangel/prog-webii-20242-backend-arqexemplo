package br.ueg.progweb2.arqexemplo.validations.impl;

import br.ueg.progweb2.arqexemplo.exceptions.AppMessageCode;
import br.ueg.progweb2.arqexemplo.model.Category;
import br.ueg.progweb2.arqexemplo.repository.CategoryRepository;
import br.ueg.progweb2.arquitetura.exceptions.BusinessException;
import br.ueg.progweb2.arquitetura.validations.IValidations;
import br.ueg.progweb2.arquitetura.validations.ValidationAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Order(2)
@Component
public class CategoryDuplicationValidation implements IValidations<Category> {
    @Autowired
    protected CategoryRepository repository;
    @Override
    public void validate(Category data, ValidationAction action) {
        if(Objects.equals(ValidationAction.CREATE, action)) {
            Optional<Category> byRegisterNumber = repository.findByName(data.getName());
            if (byRegisterNumber.isPresent()) {
                throw new BusinessException(AppMessageCode.CATEGORY_NAME_DUPLICATED, "name");
            }
        }else if(Objects.equals(ValidationAction.UPDATE, action)) {
            Optional<Category> byRegisterNumber = repository.findByName(data.getName());
            if (byRegisterNumber.isPresent()) {
                if(Objects.equals(data.getId(), byRegisterNumber.get().getId())) { return ;}
                throw new BusinessException(AppMessageCode.CATEGORY_NAME_DUPLICATED, "name");
            }
        }
    }
}
