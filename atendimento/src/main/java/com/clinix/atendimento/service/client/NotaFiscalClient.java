package com.clinix.atendimento.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("NOTA-FISCAL-SERVICE")
public interface NotaFiscalClient {
    @GetMapping("emitir/{atendimentoId}")
    void emitir(@RequestParam("atendimentoId") String atendimentoId);
}
