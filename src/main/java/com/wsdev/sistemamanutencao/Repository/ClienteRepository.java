package com.wsdev.sistemamanutencao.Repository;

import com.wsdev.sistemamanutencao.Models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>
{
}
