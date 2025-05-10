package com.wsdev.sistemamanutencao.Repository;

import com.wsdev.sistemamanutencao.Models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long>
{
}
