package com.wsdev.maintenanceSystem.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table( name = "tb_customer")
public class CustomerModel
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private String name;

    @Pattern( regexp = "^(\\(\\d{2}\\)\\s?|\\d{2})\\d{4,5}-?\\d{4}$", message = "Telefone inválido. Use o formato (11) 91234-5678 ou 11912345678" )
    private String telephone;

    @Email( message = "O campo [email] deve conter um e-mail valído." )
    private String email;

    @Embedded
    private AddressModel address;

    @OneToMany( mappedBy = "customer", cascade = CascadeType.ALL )
    private List<MaintenanceModel> maintenances;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public List<MaintenanceModel> getMaintenances()
    {
        return maintenances;
    }

    public void setMaintenances( List<MaintenanceModel> maintenances )
    {
        this.maintenances = maintenances;
    }

    public AddressModel getAddress()
    {
        return address;
    }

    public void setAddress( AddressModel address )
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone( String telephone )
    {
        this.telephone = telephone;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( LocalDateTime createdAt )
    {
        this.createdAt = createdAt;
    }
}
