package br.ueg.progweb2.arqexemplo.mapper;

import br.ueg.progweb2.arqexemplo.model.Category;
import br.ueg.progweb2.arqexemplo.model.dtos.CategoryDTO;
import br.ueg.progweb2.arquitetura.mapper.SimpleGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, //checa se o valor é nulo antes de setar
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE //se o valor não for passado não faz nada.
)
public interface CategoryMapper extends SimpleGenericMapper<
        CategoryDTO,
        Category, // Model
        Long // PK_TYPE
        > {}
