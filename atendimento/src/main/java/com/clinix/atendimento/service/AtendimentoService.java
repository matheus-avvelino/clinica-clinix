package com.clinix.atendimento.service;

import lombok.RequiredArgsConstructor;
import com.clinix.atendimento.model.Atendimento;
import com.clinix.atendimento.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public Atendimento create(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    public Optional<Atendimento> findById(String id) {
        return atendimentoRepository.findById(id);
    }
}
