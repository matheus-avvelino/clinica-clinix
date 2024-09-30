package com.clinix.pagamento.service;


import com.clinix.pagamento.model.Psicologo;
import com.clinix.pagamento.service.client.PsicologoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class PsicologoService {

    private final PsicologoClient psicologoClient;

    public Psicologo getById(Long id){
        return psicologoClient.getById(id);
//        RestClient restClient = RestClient.create();
//        var serverUrl = String.format("http://localhost:8082/%d", id);
//        return restClient.get()
//                .uri(serverUrl)
//                .retrieve()
//                .toEntity(Psicologo.class).getBody();
    }
}
