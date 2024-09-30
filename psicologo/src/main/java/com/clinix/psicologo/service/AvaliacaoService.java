package com.clinix.psicologo.service;

import com.clinix.psicologo.model.Avaliacao;
import com.clinix.psicologo.service.client.AvaliacaoClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AvaliacaoService {
    private final AvaliacaoClient avaliacaoClient;
    private static Map<Long, List<Avaliacao>> CACHE = new ConcurrentHashMap<>();

    @CircuitBreaker(name = "avaliacaoService", fallbackMethod = "buscarNoCache")
    public List<Avaliacao> getAllById(Long psicologoId){
        List<Avaliacao> avaliacaoList = avaliacaoClient.getById(psicologoId);
        CACHE.put(psicologoId, avaliacaoList);
        return avaliacaoClient.getById(psicologoId);
    }

    private List<Avaliacao> buscarNoCache(Long psicologoId, Throwable e){
        log.info("Buscando no cache");
        return CACHE.getOrDefault(psicologoId,new ArrayList<>());
    }
}
