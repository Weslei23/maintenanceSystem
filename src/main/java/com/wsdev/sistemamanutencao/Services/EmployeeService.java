package com.wsdev.sistemamanutencao.Services;

import com.wsdev.sistemamanutencao.Models.EmployeeModel;
import com.wsdev.sistemamanutencao.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getEmployeers()
    {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeModel> getEmployeeById(Long id )
    {
        return employeeRepository.findById( id );
    }

    public EmployeeModel addNewEmployee( EmployeeModel employee )
    {
        return employeeRepository.save( employee );
    }

    public Optional<EmployeeModel> updateEmployee( Long id, EmployeeModel employeeUpdated )
    {
        return employeeRepository.findById( id ).map(employee ->
        {
            employee.setName( employeeUpdated.getName() );
            employee.setTelephone( employeeUpdated.getTelephone() );
            employee.setSpecialty( employeeUpdated.getSpecialty() );
            return employeeRepository.save( employee );
        } );
    }

    public void deleteEmployeeById( Long id )
    {
        employeeRepository.deleteById( id );
    }
}
