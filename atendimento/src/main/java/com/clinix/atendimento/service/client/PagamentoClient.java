package com.clinix.atendimento.service.client;

import com.clinix.atendimento.model.Atendimento;
import com.clinix.atendimento.model.PagamentoResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PAGAMENTO-SERVICE")
public interface PagamentoClient {
    @PostMapping("/")
    PagamentoResponsePayload calcularPagamento(@RequestBody Atendimento atendimento);
}
