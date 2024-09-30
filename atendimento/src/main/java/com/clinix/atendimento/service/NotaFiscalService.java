package com.clinix.atendimento.service;

import com.clinix.atendimento.service.client.NotaFiscalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalClient notaFiscalClient;

    public void emitir(String atendimentoId){
        notaFiscalClient.emitir(atendimentoId);
    }
}
