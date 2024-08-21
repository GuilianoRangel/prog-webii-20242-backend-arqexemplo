package br.ueg.progweb2.arqexemplo.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class StudentListDTO  {
    private Long id;

    private String registerNumber;

    private String name;

    private String course;
}
