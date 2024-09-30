package com.clinix.nota_fiscal.controller;

import com.clinix.nota_fiscal.model.NotaFiscal;
import com.clinix.nota_fiscal.service.NotaFiscalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NotaFiscalController {

    private final NotaFiscalService notaFiscalService;

    @GetMapping("/emitir/{atendimentoId}")
    public ResponseEntity<?> emitir(@PathVariable String atendimentoId) {
        NotaFiscal notaFiscal = NotaFiscal.builder().atendimentoId(atendimentoId).id(new Random().nextLong()).build();
        try {
            NotaFiscal nota = notaFiscalService.emitir(notaFiscal);
            return ResponseEntity.ok().body(nota);
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNota(@PathVariable Long id) {
        NotaFiscal notaFiscal = notaFiscalService.findById(id);
        return ResponseEntity.ok(Map.of("nota", notaFiscal));
    }
}
