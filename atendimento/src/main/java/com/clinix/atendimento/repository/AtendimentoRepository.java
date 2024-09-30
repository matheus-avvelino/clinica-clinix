package com.clinix.atendimento.repository;

import com.clinix.atendimento.model.Atendimento;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AtendimentoRepository extends MongoRepository<Atendimento, String> {

}
