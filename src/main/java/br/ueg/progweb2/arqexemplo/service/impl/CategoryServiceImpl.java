package br.ueg.progweb2.arqexemplo.service.impl;

import br.ueg.progweb2.arqexemplo.model.Category;
import br.ueg.progweb2.arqexemplo.repository.CategoryRepository;
import br.ueg.progweb2.arqexemplo.service.CategoryService;
import br.ueg.progweb2.arquitetura.service.impl.GenericCrudWithValidationsService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoryServiceImpl extends GenericCrudWithValidationsService<Category, Long, CategoryRepository> implements CategoryService {
    @Override
    protected void prepareToCreate(Category dado) {
        dado.setId(null);
        if(Objects.nonNull(dado.getName())) {
            dado.setName(dado.getName().toUpperCase());
        }
    }

}
