package br.ueg.progweb2.arqexemplo.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TaskCreateDTO {

    @NotNull
    @Schema(title = "Descrição", description = "Descrição da tarefa" )
    private String description;

    @Schema(title = "Categoria ID", description = "ID da Categoria da tarefa" )
    private Long category_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Schema(title = "Data de Vencimento", description = "Data quando limite para execução da tarefa")
    private LocalDate dueDate;
}
