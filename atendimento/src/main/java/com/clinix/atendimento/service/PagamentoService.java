package com.clinix.atendimento.service;

import com.clinix.atendimento.model.Atendimento;
import com.clinix.atendimento.model.PagamentoResponsePayload;
import com.clinix.atendimento.service.client.PagamentoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoClient pagamentoClient;
    public PagamentoResponsePayload getTotalPreco(Atendimento atendimento) {
        return pagamentoClient.calcularPagamento(atendimento);

        //        var serverUrl = "http://localhost:8084/";
//        RestClient restClient = RestClient.create();
//        return restClient.post()
//                .uri(serverUrl)
//                .body(atendimento)
//                .retrieve()
//                .toEntity(PagamentoResponsePayload.class).getBody();
    }
}
