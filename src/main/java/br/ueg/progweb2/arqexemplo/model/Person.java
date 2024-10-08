package br.ueg.progweb2.arqexemplo.model;

import br.ueg.progweb2.arquitetura.model.GenericModel;
import jakarta.persistence.*;
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
@Table(name = "PESSOA")
public class Person implements GenericModel<Long> {
    public final static String SEQUENCE_NAME = "person_sequence";//Mude o nome para criar outro

    @Id
    @SequenceGenerator(
            name=SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME+"_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = SEQUENCE_NAME
    )
    @Column(name = "CODIGO", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "ANIVERSARIO")
    private LocalDate birthday;

    @Column(name ="SEXO")
    private String gender;
}
