package br.ueg.progweb2.arqexemplo.service;

import br.ueg.progweb2.arqexemplo.model.Student;
import br.ueg.progweb2.arquitetura.service.CrudService;

import java.util.List;

public interface StudentService extends CrudService<Student, Long> {
    List<Student> listYesterdayRegisters();
}
