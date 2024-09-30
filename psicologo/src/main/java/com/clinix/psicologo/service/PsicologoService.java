package com.clinix.psicologo.service;

import com.clinix.psicologo.model.Psicologo;
import com.clinix.psicologo.repository.PsicologoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PsicologoService {
    private final PsicologoRepository psicologoRepository;
    public List<Psicologo> getAll(){
        return psicologoRepository.findAll();
    }
    public Optional<Psicologo> getById(Long id){
        return psicologoRepository.findById(id);
    }
}
