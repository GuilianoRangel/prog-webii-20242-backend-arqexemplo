package br.ueg.progweb2.arqexemplo.model.dtos;

import br.ueg.progweb2.arquitetura.model.dtos.GenericDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Schema(name = "TaskUpdateDTO", description = "DTO para tarefas", allOf = { GenericDTO.class })
public class TaskUpdateDTO extends GenericDTO<Long> {

    private Long id;

    @NotNull
    @Schema(title = "Descrição", description = "Descrição da tarefa" )
    private String description;

    private Boolean completed;

    @Schema(title = "Categoria ID", description = "ID da Categoria da tarefa" )
    private Long category_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;


    @NotNull
    @Override
    @Schema(description = "ID da tarefa", example = "1", type = "integer", format = "int64")
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
