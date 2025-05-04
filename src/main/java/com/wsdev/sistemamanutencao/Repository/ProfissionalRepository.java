package com.wsdev.sistemamanutencao.Repository;

import com.wsdev.sistemamanutencao.Models.ProfissionalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<ProfissionalModel, Long>
{
}
