package com.clinix.psicologo.service.client;

import com.clinix.psicologo.model.Avaliacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("AVALIACAO-SERVICE")
public interface AvaliacaoClient {

    @GetMapping("/{id}")
    List<Avaliacao> getById(@PathVariable Long id);
}
