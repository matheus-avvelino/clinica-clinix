package com.clinix.atendimento.controller;

import com.clinix.atendimento.model.PagamentoResponsePayload;
import com.clinix.atendimento.repository.AtendimentoRepository;
import com.clinix.atendimento.service.NotaFiscalService;
import com.clinix.atendimento.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import com.clinix.atendimento.model.Atendimento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.clinix.atendimento.service.AtendimentoService;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AtendimentoController {

    private final AtendimentoService atendimentoService;
    private final PagamentoService pagamentoService;
    private final NotaFiscalService notaFiscalService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Atendimento atendimento) {
        log.info("Criando atendimento: {}", atendimento);
        PagamentoResponsePayload totalPagamento =  pagamentoService.getTotalPreco(atendimento);
        atendimento.setTotalPrecoAtendimento(totalPagamento.totalPrecoAtendimento());
        Atendimento saved = atendimentoService.create(atendimento);
        log.info("Atendimento salvo: {}", saved);
        notaFiscalService.emitir(atendimento.getId());
        return ResponseEntity.ok(Map.of("Atendimento salvo com sucesso: ", atendimento));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Atendimento> atendimentos = atendimentoService.findAll();
        return ResponseEntity.ok(atendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        log.info("Buscando um atendimento com ID: {}", id);
        Optional<Atendimento> optatendimento = atendimentoService.findById(id);
        if(optatendimento.isPresent()) {
            return ResponseEntity.ok(optatendimento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


