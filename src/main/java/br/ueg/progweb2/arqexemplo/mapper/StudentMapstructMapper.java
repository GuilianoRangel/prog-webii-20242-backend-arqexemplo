package br.ueg.progweb2.arqexemplo.mapper;

import br.ueg.progweb2.arqexemplo.model.Student;
import br.ueg.progweb2.arqexemplo.model.dtos.StudentCreateDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.StudentDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.StudentListDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.StudentUpdateDTO;
import br.ueg.progweb2.arquitetura.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, //checa se o valor é nulo antes de setar
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE //se o valor não for passado não faz nada.
)
public interface StudentMapstructMapper extends GenericMapper<
        StudentDTO,
        StudentCreateDTO,
        StudentUpdateDTO,
        StudentListDTO,
        Student,
        Long
        > {
    @Mapping(target = "course", source = "courseRegister")
    @Override
    Student fromModelCreatedToModel(StudentCreateDTO studentCreateDTO);
}
