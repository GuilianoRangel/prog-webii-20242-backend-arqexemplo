package br.ueg.progweb2.arqexemplo.service;

import br.ueg.progweb2.arqexemplo.model.Task;
import br.ueg.progweb2.arquitetura.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService extends CrudService<Task, Long> {
    Task completedTask(Long id);
    Page<Task> getIncompleteTasks(Pageable pageable);
    List<Task> getIncompleteTasks();

}
