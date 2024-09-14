package br.ueg.progweb2.arqexemplo.controllers;

import br.ueg.progweb2.arqexemplo.mapper.PersonMapper;
import br.ueg.progweb2.arqexemplo.model.Person;
import br.ueg.progweb2.arqexemplo.model.dtos.PersonDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.PersonDataDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.PersonListDTO;
import br.ueg.progweb2.arqexemplo.service.PersonService;
import br.ueg.progweb2.arquitetura.controllers.GenericCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/person")
public class PersonController extends
        GenericCRUDController<
                PersonDTO, // DTO Geral
                PersonDataDTO, // DTO Create
                PersonDataDTO, // DTO Update
                PersonListDTO,
                Person, // Modelo
                Long, // PK_TYPE
                PersonService, //Interface Serviço
                PersonMapper> // Mapper
{

}
