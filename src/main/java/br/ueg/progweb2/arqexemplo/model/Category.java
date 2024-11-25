
package br.ueg.progweb2.arqexemplo.model;

import br.ueg.progweb2.arquitetura.interfaces.ISearchFieldData;
import br.ueg.progweb2.arquitetura.model.GenericModel;
import br.ueg.progweb2.arquitetura.model.annotation.Searchable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORY")
public  class Category implements GenericModel<Long>, ISearchFieldData<Long> {

    @Id
    @SequenceGenerator(
            name="category_sequence",
            sequenceName = "category_sequence_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "category_sequence"
    )
    @Column(name = "id", nullable = false)
    @Searchable(label = "ID")
    private Long id;

    @NotNull
    @Column(name = "nome",  nullable = false, length = 40)
    @Searchable(label = "Nome", autoComplete = true)
    private String name;

    @Override
    public String getSearchDescription() {
        return this.getId() + " - "+this.getName();
    }
}
