package br.ueg.progweb2.arqexemplo.controllers;

import br.ueg.progweb2.arqexemplo.mapper.TaskMapper;
import br.ueg.progweb2.arqexemplo.model.Task;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskCreateDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskUpdateDTO;
import br.ueg.progweb2.arqexemplo.service.TaskService;
import br.ueg.progweb2.arquitetura.controllers.GenericCRUDController;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${app.api.base}/task")
public class TaskController extends
        GenericCRUDController<
                TaskDTO, //DTO Geral
                TaskCreateDTO, //DTO Create
                TaskUpdateDTO, //DTO Update
                TaskDTO, //DTO List
                Task, // Modelo
                Long, // PK_TYPE
                TaskService, //Interface Serviço
                TaskMapper> // Mapper
{
    @PostMapping(path = "/complete/{id}")
    @Operation(description = "End point para completar a tarefa")
    public ResponseEntity<Object> complated(
            @PathVariable("id") Long id
    ) {
        TaskDTO dtoResult;
        dtoResult = mapper.toDTO(service.completedTask(id));
        return ResponseEntity.ok(dtoResult);
    }
}
