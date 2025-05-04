package com.wsdev.sistemamanutencao.Repository;

import com.wsdev.sistemamanutencao.Models.ManutencaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<ManutencaoModel, Long>
{
}
