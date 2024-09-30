package com.clinix.psicologo.payload;

import com.clinix.psicologo.model.Avaliacao;
import com.clinix.psicologo.model.Psicologo;

import java.util.List;

public record ResponsePayload(Psicologo psicologo, List<Avaliacao> avaliacoes){

}
