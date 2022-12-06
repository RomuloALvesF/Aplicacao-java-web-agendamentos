package com.pilatesapp.agendamento.repository;

import com.pilatesapp.agendamento.model.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AgendamentoRepository extends CrudRepository<AgendamentoModel, String> {


    AgendamentoModel findById(long id);
}
