package br.ueg.progweb2.arqexemplo.model;

import br.ueg.progweb2.arquitetura.interfaces.ISearchFieldData;
import br.ueg.progweb2.arquitetura.model.GenericModel;
import br.ueg.progweb2.arquitetura.model.annotation.Searchable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TASK")
public  class Task implements GenericModel<Long>, ISearchFieldData<Long> {

    @Id
    @SequenceGenerator(
            name="task_sequence",
            sequenceName = "task_sequence_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "task_sequence"
    )
    @Column(name = "id", nullable = false)
    @Searchable(label="Código")
    private Long id;

    @NotNull
    @Column(name = "descricao",  nullable = false, length = 200)
    @Searchable(label = "Descrição")
    private String description;

    @Column(name = "concluida")
    @Searchable(label = "Concluída")
    private Boolean completed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_category_tipo"))
    @Searchable(label="Categória", listEntityValues = true)
    private Category category;

    @Column(name = "data_final")
    @Searchable(label = "Dta. Final")
    private LocalDate dueDate;

    @Override
    public String getSearchDescription() {
        return this.getId()+" - "+this.getDescription();
    }
}
