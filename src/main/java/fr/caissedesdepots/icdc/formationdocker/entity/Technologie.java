package fr.caissedesdepots.icdc.formationdocker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "TECHNOLOGIES")
public class Technologie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "DOMAINE")
    private String domaine;
}
