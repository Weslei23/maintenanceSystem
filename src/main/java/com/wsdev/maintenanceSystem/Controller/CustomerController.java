package com.wsdev.maintenanceSystem.Controller;

import com.wsdev.maintenanceSystem.Models.CustomerModel;
import com.wsdev.maintenanceSystem.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/list")
    public String getCustomers( Model model )
    {
        List<CustomerModel> list = customerService.getCustomers();
        model.addAttribute( "customer", list );
        return "customerList";
    }

    @GetMapping( "/{id}" )
    public CustomerModel getCustomerById( @PathVariable Long id )
    {
        return customerService.getCustomerById( id ).orElse( null );
    }

    @PostMapping( "/addcustomer" )
//    public String addCustomer( @ModelAttribute CustomerModel customer )
    public ResponseEntity<CustomerModel> addCustomer( @RequestBody CustomerModel customer )
    {
        return ResponseEntity.status( HttpStatus.CREATED ).body( customerService.addCustomer( customer ) );

//        customerService.addCustomer( customer );
//        return "clienteRegister";
    }

    @PutMapping("/{id}" )
    public  CustomerModel updateCustomer( @PathVariable Long id, @RequestBody CustomerModel customerUpdated )
    {
        return customerService.updateCustomer( id, customerUpdated );
    }

    @DeleteMapping( "/delete/{id}" )
    public ResponseEntity<String>  deleteCustomerById( @PathVariable Long id )
    {
        customerService.deleteCustomerById( id );
        return ResponseEntity.status( HttpStatus.OK ).body("Customer deleted successfully!");
//        customerService.deleteCustomerById( id );
    }
}
