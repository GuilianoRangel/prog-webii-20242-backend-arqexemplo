package br.ueg.progweb2.arqexemplo.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO{
    private Long id;

    private String registerNumber;

    private String name;

    private String course;

    private LocalDate createdDate;
}
