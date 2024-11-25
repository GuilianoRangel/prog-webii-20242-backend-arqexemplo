package br.ueg.progweb2.arqexemplo.repository;

import br.ueg.progweb2.arqexemplo.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository
        extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    Page<Task> findByCompletedFalseOrCompletedIsNull(Pageable pageable);

    List<Task> findByCompletedFalse();
}
