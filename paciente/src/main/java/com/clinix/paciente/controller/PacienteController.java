package com.clinix.paciente.controller;

import com.clinix.paciente.model.Paciente;
import com.clinix.paciente.service.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        log.info("Buscando um paciente com ID: {}", id);
        Optional<Paciente> optpaciente = pacienteService.findById(id);
        if(optpaciente.isPresent()) {
            return ResponseEntity.ok(optpaciente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pacienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Paciente paciente) {
        Paciente saved = pacienteService.create(paciente);
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Paciente paciente) {
        pacienteService.update(paciente);
        return ResponseEntity.ok().build();
    }
}
