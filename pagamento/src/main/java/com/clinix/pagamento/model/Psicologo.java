package com.clinix.pagamento.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Psicologo {

    private Long id;
    private String crp;
    private String nome;
    private String email;
    private String telefone;
    private Abordagem Abordagem;
    private BigDecimal precoAtendimento;
}
