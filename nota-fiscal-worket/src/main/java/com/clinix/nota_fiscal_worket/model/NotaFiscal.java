package com.clinix.nota_fiscal_worket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotaFiscal {
    private Long id;
    private String atendimentoId;
}
