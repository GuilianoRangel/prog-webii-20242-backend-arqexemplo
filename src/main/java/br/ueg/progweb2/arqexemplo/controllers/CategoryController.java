package br.ueg.progweb2.arqexemplo.controllers;

import br.ueg.progweb2.arqexemplo.mapper.CategoryMapper;
import br.ueg.progweb2.arqexemplo.model.Category;
import br.ueg.progweb2.arqexemplo.model.dtos.CategoryDTO;
import br.ueg.progweb2.arqexemplo.service.CategoryService;
import br.ueg.progweb2.arquitetura.controllers.GenericCRUDController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/category")
@CrossOrigin()
public class CategoryController extends GenericCRUDController<
        CategoryDTO,
        CategoryDTO,
        CategoryDTO,
        CategoryDTO,
        Category,
        Long,
        CategoryService,
        CategoryMapper
        > {


}
