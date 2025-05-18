package com.wsdev.maintenanceSystem.Services;

import com.wsdev.maintenanceSystem.Models.EmployeeModel;
import com.wsdev.maintenanceSystem.Repository.EmployeeRepository;
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

    public EmployeeModel addEmployee(EmployeeModel employee )
    {
        return employeeRepository.save( employee );
    }

    public EmployeeModel updateEmployee( Long id, EmployeeModel employeeUpdated )
    {
        EmployeeModel employee = employeeRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Funcionário não encontrado" ) );

        employee.setName( employeeUpdated.getName() );
        employee.setTelephone( employeeUpdated.getTelephone() );
        employee.setSpecialty( employeeUpdated.getSpecialty() );

        return employeeRepository.save( employee );
    }

    public void deleteEmployeeById( Long id )
    {
        employeeRepository.deleteById( id );
    }
}
