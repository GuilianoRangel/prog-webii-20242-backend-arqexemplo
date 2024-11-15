package br.ueg.progweb2.arqexemplo.model.dtos;

import br.ueg.progweb2.arquitetura.model.dtos.GenericDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Schema(name = "TaskDTO", description = "DTO para tarefas", allOf = { GenericDTO.class })
public class TaskDTO extends GenericDTO<Long> {

    private Long id;

    @Schema(title = "Descrição", description = "Descrição da tarefa" )
    private String description;

    @Schema(title = "Concluída", description = "Tarefa concluída")
    private Boolean completed;

    @Schema(title = "Categoria ID", description = "ID da Categoria da tarefa" )
    private Long category_id;

    @Schema(title = "Categoria nome", description = "Nome da Categoria da tarefa" )
    private String category_name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Schema(title = "Data de Vencimento", description = "Data quando limite para execução da tarefa")
    private LocalDate dueDate;

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
