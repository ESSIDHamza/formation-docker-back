package fr.caissedesdepots.icdc.formationdocker.controller;

import fr.caissedesdepots.icdc.formationdocker.dto.TechnologieDto;
import fr.caissedesdepots.icdc.formationdocker.service.TechnologieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin("*")
public class TechnologieController {
    private final TechnologieService technologieService;

    public TechnologieController(final TechnologieService technologieService) {
        this.technologieService = technologieService;
    }

    @GetMapping
    public ResponseEntity<List<TechnologieDto>> getAllTechnologies() {
        return ResponseEntity.ok(this.technologieService.getAllTechnologies());
    }

    @PostMapping("/fill-data")
    public ResponseEntity<Void> fillTechnologiesData() {
        this.technologieService.fillTechnologiesData();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/file")
    public ResponseEntity<List<String>> readFile() throws IOException {
        return ResponseEntity.ok(this.technologieService.readFile());
    }

}
