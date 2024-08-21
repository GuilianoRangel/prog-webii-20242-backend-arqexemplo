package br.ueg.progweb2.arqexemplo.controllers;

import br.ueg.progweb2.arqexemplo.mapper.StudentMapstructMapper;
import br.ueg.progweb2.arqexemplo.model.Student;
import br.ueg.progweb2.arqexemplo.model.dtos.StudentCreateDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.StudentDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.StudentListDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.StudentUpdateDTO;
import br.ueg.progweb2.arqexemplo.service.StudentService;
import br.ueg.progweb2.arquitetura.controllers.GenericCRUDController;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "${api.version}/crud-student")
public class StudentCRUDController extends GenericCRUDController<
        StudentDTO,
        StudentCreateDTO,
        StudentUpdateDTO,
        StudentListDTO,
        Student,
        Long,
        StudentService,
        StudentMapstructMapper
        > {

    @GetMapping(path = "/yesterday-registers")
    @Operation(description = "lista todos os estudantes matriculados antes de hoje")
    public ResponseEntity<List<Student>> listYesterdayRegisters() {
        return ResponseEntity.of(
                Optional.ofNullable(service.listYesterdayRegisters())
        );
    }

}
