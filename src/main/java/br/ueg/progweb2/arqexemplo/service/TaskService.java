package br.ueg.progweb2.arqexemplo.service;

import br.ueg.progweb2.arqexemplo.model.Task;
import br.ueg.progweb2.arquitetura.service.CrudService;

public interface TaskService extends CrudService<Task, Long> {
    Task completedTask(Long id);
}
