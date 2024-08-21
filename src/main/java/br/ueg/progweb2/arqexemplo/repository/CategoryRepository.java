package br.ueg.progweb2.arqexemplo.repository;

import br.ueg.progweb2.arqexemplo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}
