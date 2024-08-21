package br.ueg.progweb2.arqexemplo.repository;

import br.ueg.progweb2.arqexemplo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository
        extends JpaRepository<Task, Long> {
}
