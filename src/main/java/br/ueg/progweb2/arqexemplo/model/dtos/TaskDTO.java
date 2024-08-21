package br.ueg.progweb2.arqexemplo.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDTO {
    private Long id;

    private String description;

    private Boolean completed;

    private Long category_id;

    private String category_name;
}
