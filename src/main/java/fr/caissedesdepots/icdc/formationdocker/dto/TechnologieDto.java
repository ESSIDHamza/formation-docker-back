package fr.caissedesdepots.icdc.formationdocker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class TechnologieDto implements Serializable {
    private Integer id;
    private String nom;
    private String domaine;
}
