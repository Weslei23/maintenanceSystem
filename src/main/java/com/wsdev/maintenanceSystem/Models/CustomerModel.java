package com.wsdev.maintenanceSystem.Models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table( name = "tb_customer")
public class CustomerModel
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    private String telephone;

    private String email;

    private String address;

    @OneToMany( mappedBy = "customer", cascade = CascadeType.ALL )
    private List<MaintenanceModel> maintenances;

    private OffsetDateTime createdAt;

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

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
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

    public void setTelephone(String telephone )
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

    public OffsetDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( OffsetDateTime createdAt )
    {
        this.createdAt = createdAt;
    }
}
