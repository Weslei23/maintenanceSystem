package com.wsdev.sistemamanutencao.Repository;

import com.wsdev.sistemamanutencao.Models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>
{
}
