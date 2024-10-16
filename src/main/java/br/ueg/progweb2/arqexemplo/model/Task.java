package br.ueg.progweb2.arqexemplo.model;

import br.ueg.progweb2.arquitetura.model.GenericModel;
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
public  class Task implements GenericModel<Long> {

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
    private Long id;

    @NotNull
    @Column(name = "descricao",  nullable = false, length = 200)
    private String description;

    @Column(name = "concluida")
    private Boolean completed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_category_tipo"))
    private Category category;

    @Column(name = "data_final")
    private LocalDate dueDate;
}
