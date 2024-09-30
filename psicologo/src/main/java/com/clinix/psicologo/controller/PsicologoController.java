package com.clinix.psicologo.controller;

import com.clinix.psicologo.model.Avaliacao;
import com.clinix.psicologo.model.Psicologo;
import com.clinix.psicologo.payload.ResponsePayload;
import com.clinix.psicologo.service.AvaliacaoService;
import com.clinix.psicologo.service.PsicologoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class PsicologoController {
    private final PsicologoService psicologoService;
    private final AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<Psicologo>> getAll(){
        return ResponseEntity.ok(psicologoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        log.info("Buscando um psicologo com ID: {}", id);
        Optional<Psicologo> optpsicologo = psicologoService.getById(id);
        if(optpsicologo.isPresent()){
            return ResponseEntity.ok(optpsicologo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/complete")
    public ResponseEntity<?> getByIdComAvaliacoes(@PathVariable Long id){
        log.info("Buscando um psicologo com ID: {}", id);

        Optional<Psicologo> optpsicologo = psicologoService.getById(id);

        if(optpsicologo.isPresent()){
            List<Avaliacao> allById = avaliacaoService.getAllById(id);
            ResponsePayload responsePayload = new ResponsePayload(optpsicologo.get(), allById);
            return ResponseEntity.ok(responsePayload);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
