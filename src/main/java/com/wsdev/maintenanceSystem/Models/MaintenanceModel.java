package com.wsdev.maintenanceSystem.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table( name = "tb_maintenance")
public class MaintenanceModel
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private LocalDate scheduledDate;

    @Enumerated( EnumType.STRING )
    private StatusModel status;

    @Column( nullable = false )
    private String descriptionService;

    @ManyToOne
    @JoinColumn( name = "customer_id" )
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn( name = "employee_id" )
    private EmployeeModel employee;

    @Column( nullable = false )
    private OffsetDateTime createdAt;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public CustomerModel getCustomer()
    {
        return customer;
    }

    public void setCustomer( CustomerModel customer )
    {
        this.customer = customer;
    }

    public String getDescriptionService()
    {
        return descriptionService;
    }

    public void setDescriptionService( String descriptionService )
    {
        this.descriptionService = descriptionService;
    }

    public LocalDate getScheduledDate()
    {
        return scheduledDate;
    }

    public void setScheduledDate( LocalDate scheduledDate )
    {
        this.scheduledDate = scheduledDate;
    }

    public StatusModel getStatus()
    {
        return status;
    }

    public void setStatus( StatusModel status )
    {
        this.status = status;
    }

    public EmployeeModel getEmployee()
    {
        return employee;
    }

    public void setEmployee( EmployeeModel employee )
    {
        this.employee = employee;
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
