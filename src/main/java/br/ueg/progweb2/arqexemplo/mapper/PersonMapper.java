package br.ueg.progweb2.arqexemplo.mapper;

import br.ueg.progweb2.arqexemplo.model.Person;
import br.ueg.progweb2.arqexemplo.model.dtos.PersonDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.PersonDataDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.PersonListDTO;
import br.ueg.progweb2.arquitetura.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PersonMapper extends GenericMapper<
        PersonDTO, // DTO Geral
        PersonDataDTO, // DTO Create
        PersonDataDTO, // DTO Update
        PersonListDTO, // DTO List
        Person, // Model
        Long // PK_TYPE
        > {
}
