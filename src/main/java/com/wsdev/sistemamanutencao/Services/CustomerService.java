package com.wsdev.sistemamanutencao.Services;

import com.wsdev.sistemamanutencao.Models.CustomerModel;
import com.wsdev.sistemamanutencao.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerModel> getCustomers()
    {
        return customerRepository.findAll();
    }

    public Optional<CustomerModel> getCustomerById( Long id )
    {
        return customerRepository.findById( id );
    }

    public CustomerModel addNewCustomer( CustomerModel customer )
    {
        return customerRepository.save( customer );
    }

    public CustomerModel updateCustomer( Long id, CustomerModel customerUpdated )
    {
        CustomerModel customer = customerRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Cliente não encontrado" ) );

        customer.setName( customerUpdated.getName() );
        customer.setTelephone( customerUpdated.getTelephone() );
        customer.setEmail( customerUpdated.getEmail() );
        customer.setAddress( customerUpdated.getAddress() );

        return customerRepository.save( customer );
    }

    public void deleteCustomerById( Long id )
    {
        customerRepository.deleteById( id );
    }
}
