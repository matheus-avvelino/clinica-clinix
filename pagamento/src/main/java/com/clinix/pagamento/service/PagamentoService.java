package com.clinix.pagamento.service;

import com.clinix.pagamento.model.Atendimento;
import com.clinix.pagamento.model.Modalidade;
import com.clinix.pagamento.model.Psicologo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PsicologoService psicologoService;

    @Value("${modalidade.presencial}")
    private  BigDecimal modalidadePRESENCIAL;

    @Value("${modalidade.online}")
    private  BigDecimal modalidadeONLINE;

    public BigDecimal calcularPagamento(Atendimento atendimento) {
        log.info("Calculando pagamento do Atendimento: {}", atendimento);
        Psicologo psicologo = psicologoService.getById(atendimento.getPsicologId());
        BigDecimal precoAtendimento = getValue(atendimento.getModalidade()).multiply(psicologo.getPrecoAtendimento()).add(psicologo.getPrecoAtendimento());
        return precoAtendimento;
    }

    private BigDecimal getValue(Modalidade modalidade) {
        return switch (modalidade){
            case PRESENCIAL -> modalidadePRESENCIAL;
            case ONLINE -> modalidadeONLINE;
        };
    }
}
