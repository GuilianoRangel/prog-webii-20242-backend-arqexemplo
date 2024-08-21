package br.ueg.progweb2.arqexemplo.service.impl;

import br.ueg.progweb2.arqexemplo.model.Task;
import br.ueg.progweb2.arqexemplo.repository.TaskRepository;
import br.ueg.progweb2.arqexemplo.service.TaskService;
import br.ueg.progweb2.arquitetura.exceptions.BusinessLogicException;
import br.ueg.progweb2.arquitetura.service.impl.GenericCrudWithValidationsService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TaskServiceImpl extends GenericCrudWithValidationsService<Task, Long, TaskRepository> implements TaskService {
    @Override
    protected void prepareToCreate(Task dado) {
        dado.setId(null);
        dado.setCompleted(false);
    }

    @Override
    protected void validateBusinessLogicForInsert(Task dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Task dado) {
    }

    @Override
    protected void validateBusinessLogic(Task dado) {

    }

    @Override
    protected void validateMandatoryFields(Task dado) {
        if(
                Strings.isEmpty(dado.getDescription())||
                        (Objects.isNull(dado.getCategory()) ||
                                dado.getCategory().getId()==null)
        ){
            //throw new MandatoryException("Campos obrigatórios não preenchidos");
        }
    }

    @Override
    public Task completedTask(Long id){
        Task task = this.getById(id);
        if(task.getCompleted()){
            throw new BusinessLogicException("Tarefa já completada");
        }
        task.setCompleted(true);
        task = repository.save(task);
        return task;
    }
}
