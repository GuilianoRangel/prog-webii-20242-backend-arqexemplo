package br.ueg.progweb2.arqexemplo.mapper;

import br.ueg.progweb2.arqexemplo.model.Task;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskCreateDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskDTO;
import br.ueg.progweb2.arqexemplo.model.dtos.TaskUpdateDTO;
import br.ueg.progweb2.arquitetura.mapper.GenericMapper;
import org.mapstruct.*;

import java.util.List;


@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, //checa se o valor é nulo antes de setar
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE //se o valor não for passado não faz nada.
)
public interface TaskMapper extends GenericMapper<
        TaskDTO, // DTO Geral
        TaskCreateDTO, // DTO Create
        TaskUpdateDTO, // DTO Update
        TaskDTO, // DTO List
        Task, // Model
        Long // PK_TYPE
        > {
    @Override
    Task toModel(TaskDTO taskDTO);

    @Override
    @Mapping(source = "category_id", target = "category.id" )
    Task fromModelCreatedToModel(TaskCreateDTO taskDTO);

    @Override
    @Mapping(source = "category_id", target = "category.id" )
    Task fromModelUpdatedToModel(TaskUpdateDTO taskDTO);

    @Override
    @Mapping(source = "category.id", target = "category_id")
    @Mapping(source = "category.name", target = "category_name")
    TaskDTO toDTO(Task model);

    @Override
    @Mapping(source = "category.id", target = "category_id")
    @Mapping(source = "category.name", target = "category_name")
    @Named(value = "toDTOList") // para identificar o nome desse metodo pelo mapstruct
    TaskDTO toDTOList(Task model);

    @Override
    @IterableMapping(qualifiedByName = "toDTOList") // para orientar qual metodo utilizar no caso de vários target=source;
    List<TaskDTO> fromModelToDTOList(List<Task> tasks);

    @Override
    void updateModelFromModel(@MappingTarget Task entity, Task updateEntity);
}
