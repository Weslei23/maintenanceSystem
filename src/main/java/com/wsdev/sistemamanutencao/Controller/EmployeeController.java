package com.wsdev.sistemamanutencao.Controller;

import com.wsdev.sistemamanutencao.Models.EmployeeModel;
import com.wsdev.sistemamanutencao.Repository.EmployeeRepository;
import com.wsdev.sistemamanutencao.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeers")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> getEmployeers()
    {
        return employeeService.getEmployeers();
    }

    @GetMapping( "/{id}" )
    public EmployeeModel getEmployeeById( @PathVariable Long id )
    {
        return employeeService.getEmployeeById( id ).orElse( null );
    }

    @PostMapping( "addemployee" )
    public EmployeeModel addNewEmployee( @RequestBody EmployeeModel employee )
    {
        return employeeService.addNewEmployee( employee );
    }

    @PutMapping( "/{id}" )
    public EmployeeModel updateEmployee( @PathVariable Long id, @RequestBody EmployeeModel employeeUpdated )
    {
        return employeeService.updateEmployee( id, employeeUpdated );
    }

    @DeleteMapping( "/{id}" )
    public void deleteEmployeeById( @PathVariable Long id)
    {
        employeeService.deleteEmployeeById( id );
    }
}
