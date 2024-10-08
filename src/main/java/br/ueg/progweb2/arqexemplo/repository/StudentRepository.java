package br.ueg.progweb2.arqexemplo.repository;

import br.ueg.progweb2.arqexemplo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    Optional<Student> findByRegisterNumber(String aLong);

    @Query("select s from Student s where s.createdDate < CURRENT_DATE")
    Optional<List<Student>> findYesterdayRegister();
}
