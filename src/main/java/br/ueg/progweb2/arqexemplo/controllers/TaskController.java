package br.ueg.progweb2.arqexemplo.controllers;

import br.ueg.progweb2.arqexemplo.mapper.TaskMapper;
import br.ueg.progweb2.arqexemplo.model.Task;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskCreateDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskUpdateDTO;
import br.ueg.progweb2.arqexemplo.service.TaskService;
import br.ueg.progweb2.arquitetura.controllers.GenericCRUDController;
import br.ueg.progweb2.arquitetura.exceptions.MessageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Object> completed(
            @PathVariable("id") Long id
    ) {
        TaskDTO dtoResult;
        dtoResult = mapper.toDTO(service.completedTask(id));
        return ResponseEntity.ok(dtoResult);
    }

    @PreAuthorize(value = "hasRole(#root.this.getRoleName(#root.this.ROLE_READ_ALL))")
    @GetMapping(
            path = "/incomplete/page",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(description = "lista tarefas incompletas", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem geral tarefas incompletas paginada",
                    useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "403", description = "Acesso negado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "400", description = "Erro de Negócio",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    public ResponseEntity<Page<TaskDTO>> listIncompletePage(@PageableDefault(page = 0, size = 5) Pageable page){
        Page<Task> pageEntidade = service.getIncompleteTasks(page);
        return ResponseEntity.ok(mapPageEntityToDto(pageEntidade));
    }

    @PreAuthorize(value = "hasRole(#root.this.getRoleName(#root.this.ROLE_READ_ALL))")
    @GetMapping(
            path = "/incomplete",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(description = "lista tarefas incompletas", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem geral tarefas incompletas ",
                    useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "403", description = "Acesso negado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "400", description = "Erro de Negócio",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    public ResponseEntity<List<TaskDTO>> listIncomplete(){
        List<Task> pageEntidade = service.getIncompleteTasks();
        return ResponseEntity.ok(mapper.fromModelToDTOList(pageEntidade));
    }
}
