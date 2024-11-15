package br.ueg.progweb2.arqexemplo.service.impl;

import br.ueg.progweb2.arqexemplo.exceptions.AppMessageCode;
import br.ueg.progweb2.arqexemplo.model.Task;
import br.ueg.progweb2.arqexemplo.repository.TaskRepository;
import br.ueg.progweb2.arqexemplo.service.TaskService;
import br.ueg.progweb2.arquitetura.exceptions.BusinessException;
import br.ueg.progweb2.arquitetura.service.impl.GenericCrudWithValidationsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Task completedTask(Long id){
        Task task = this.getById(id);
        if(task.getCompleted()){
            throw new BusinessException(AppMessageCode.TASK_ALREADY_COMPLETED);
        }
        task.setCompleted(true);
        task = repository.save(task);
        return task;
    }

    public Page<Task> getIncompleteTasks(Pageable pageable) {
        return repository.findByCompletedFalse(pageable);
    }

    public List<Task> getIncompleteTasks() {
        return repository.findByCompletedFalse();
    }
}
