package br.ueg.progweb2.arqexemplo.model.dtos;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDTO {
    private String name;

    private String course;
}
