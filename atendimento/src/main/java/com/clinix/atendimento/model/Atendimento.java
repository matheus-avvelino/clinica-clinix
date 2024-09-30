package com.clinix.atendimento.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Document(collection = "atendimentos")
public class Atendimento {

    @Id
    private String id;
    private Long psicologId;
    private Long pacienteId;
    private Modalidade modalidade;
    private BigDecimal totalPrecoAtendimento;
    private String data;

}
