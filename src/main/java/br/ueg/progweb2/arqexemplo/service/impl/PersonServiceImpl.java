package br.ueg.progweb2.arqexemplo.service.impl;


import br.ueg.progweb2.arqexemplo.model.Person;
import br.ueg.progweb2.arqexemplo.repository.PersonRepository;
import br.ueg.progweb2.arqexemplo.service.PersonService;
import br.ueg.progweb2.arquitetura.exceptions.MandatoryException;
import br.ueg.progweb2.arquitetura.service.impl.GenericCrudService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends GenericCrudService<Person, Long, PersonRepository> implements PersonService {



    @Override
    protected void prepareToCreate(Person dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Person dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Person dado) {

    }

    @Override
    protected void validateBusinessLogic(Person dado) {

    }

    @Override
    protected void validateMandatoryFields(Person dado) {
        if(
                Strings.isEmpty(dado.getName())
        ){
            throw new MandatoryException("Campos obrigatórios não preenchidos");
        }
    }
}
