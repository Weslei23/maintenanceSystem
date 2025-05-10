package com.wsdev.sistemamanutencao.Controller;

import com.wsdev.sistemamanutencao.Models.CustomerModel;
import com.wsdev.sistemamanutencao.Repository.CustomerRepository;
import com.wsdev.sistemamanutencao.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/customers" )
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getCustomers( Model model )
    {
        List<CustomerModel> list = customerService.getCustomers();
        model.addAttribute( "clientes", list );
        return "clienteList" ;
    }

    @GetMapping( "/{id}" )
    public CustomerModel getCustomerById( @PathVariable Long id )
    {
        return customerService.getCustomerById( id ).orElse( null );
    }

    @PostMapping( "/addcustomer" )
    public String addNewCustomer( @ModelAttribute CustomerModel customer )
    {
        customerService.addNewCustomer( customer );
        return "clienteRegister";
    }

    @PutMapping("/{id}")
    public  CustomerModel updateCustomer( @PathVariable Long id, @RequestBody CustomerModel customerUpdated )
    {
        return customerService.updateCustomer( id, customerUpdated ); // verificar
    }

    @DeleteMapping( "/{id}" )
    public void deleteCustomerById( @PathVariable Long id )
    {
        customerService.deleteCustomerById( id );
    }
}
