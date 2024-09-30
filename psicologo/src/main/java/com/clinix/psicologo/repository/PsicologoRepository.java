package com.clinix.psicologo.repository;

import com.clinix.psicologo.model.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
}
