package fr.caissedesdepots.icdc.formationdocker.repository;

import fr.caissedesdepots.icdc.formationdocker.entity.Technologie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologieRepository extends JpaRepository<Technologie, Integer> {
}
