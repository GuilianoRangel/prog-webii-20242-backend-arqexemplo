package br.ueg.progweb2.arqexemplo.repository;

import br.ueg.progweb2.arqexemplo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository
        extends JpaRepository<Person, Long> {
}
