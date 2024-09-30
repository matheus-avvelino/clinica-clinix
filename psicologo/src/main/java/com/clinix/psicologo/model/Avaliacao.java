package com.clinix.psicologo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Avaliacao {

    private Long id;
    private Long psicologoId;
    private String avaliacao;

}
