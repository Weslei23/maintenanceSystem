package com.wsdev.maintenanceSystem.Services;

import com.wsdev.maintenanceSystem.Models.CustomerModel;
import com.wsdev.maintenanceSystem.Repository.CustomerRepository;
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

    public CustomerModel addCustomer(CustomerModel customer )
    {
        if( customer != null )
        {
            return customerRepository.save( customer );
        }
        else
        {
            return null;
        }
    }

    public CustomerModel updateCustomer( Long id, CustomerModel customerUpdated )
    {
        CustomerModel customer = customerRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Cliente não encontrado" ) );

        if( customerUpdated.getName() != null )
        {
            customer.setName( customerUpdated.getName() );
        }

        if( customerUpdated.getTelephone() != null )
        {
            customer.setTelephone( customerUpdated.getTelephone() );
        }

        if( customerUpdated.getAddress() != null )
        {
            customer.setAddress( customerUpdated.getAddress() );
        }

        if( customerUpdated.getEmail() != null )
        {
            customer.setEmail( customerUpdated.getEmail() );
        }

        return customerRepository.save( customer );
    }

    public void deleteCustomerById( Long id )
    {
        customerRepository.deleteById( id );
    }
}
