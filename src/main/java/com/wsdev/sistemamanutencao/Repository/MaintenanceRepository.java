package com.wsdev.sistemamanutencao.Repository;

import com.wsdev.sistemamanutencao.Models.MaintenanceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<MaintenanceModel, Long>
{
}
