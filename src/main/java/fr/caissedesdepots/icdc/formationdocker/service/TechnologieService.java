package fr.caissedesdepots.icdc.formationdocker.service;

import fr.caissedesdepots.icdc.formationdocker.dto.TechnologieDto;
import fr.caissedesdepots.icdc.formationdocker.entity.Technologie;
import fr.caissedesdepots.icdc.formationdocker.repository.TechnologieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class TechnologieService {
    private final TechnologieRepository technologieRepository;

    @Value("${chemin-fichier}")
    private String cheminFichier;

    public TechnologieService(final TechnologieRepository technologieRepository) {
        this.technologieRepository = technologieRepository;
    }

    public List<TechnologieDto> getAllTechnologies() {
        return this.technologieRepository.findAll()
                .stream()
                .map(this::technologyEntityToDtoMapper)
                .collect(Collectors.toList());
    }

    @Transactional
    public void fillTechnologiesData() {
        Arrays.asList(
                new Technologie(null, "Docker", "DevOps"),
                new Technologie(null, "Angular", "Front"),
                new Technologie(null, "Kubernetes", "DevOps"),
                new Technologie(null, "Java", "Back")
        ).forEach(this.technologieRepository::save);
    }

    public List<String> readFile() throws IOException {
        return Files.readAllLines(Paths.get(this.cheminFichier));
    }

    private TechnologieDto technologyEntityToDtoMapper(final Technologie technologie) {
        return TechnologieDto.builder()
                .id(technologie.getId())
                .nom(technologie.getNom())
                .domaine(technologie.getDomaine())
                .build();
    }

}
