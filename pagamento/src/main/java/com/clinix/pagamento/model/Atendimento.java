package com.clinix.pagamento.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Atendimento {

    private String id;
    private Long psicologId;
    private Long pacienteId;
    private Modalidade modalidade;
    private String data;

}
