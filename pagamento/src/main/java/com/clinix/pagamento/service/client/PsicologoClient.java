package com.clinix.pagamento.service.client;

import com.clinix.pagamento.model.Psicologo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("PSICOLOGO-SERVICE")
public interface PsicologoClient {
    @GetMapping("/{id}")
    Psicologo getById(@PathVariable("id") Long id);
}
