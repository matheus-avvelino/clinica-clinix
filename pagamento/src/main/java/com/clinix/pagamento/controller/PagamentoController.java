package com.clinix.pagamento.controller;

import com.clinix.pagamento.model.Atendimento;
import com.clinix.pagamento.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class PagamentoController {

    public final PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<?> processarPagamento(@RequestBody Atendimento atendimento) {
        log.info("Atendimento: {}", atendimento);
        BigDecimal precoTotalAtendimento = pagamentoService.calcularPagamento(atendimento);
        return ResponseEntity.ok(Map.of("totalPrecoAtendimento", precoTotalAtendimento));
    }
}
