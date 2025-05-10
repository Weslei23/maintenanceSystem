package com.wsdev.sistemamanutencao.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "tb_employee" )
public class EmployeeModel
{
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        private Long id;

        @Column( nullable = false )
        private String name;

        @Column( nullable = false )
        private String telephone;

        @Column( nullable = false )
        private String specialty;

        @OneToMany( mappedBy = "employee", cascade = CascadeType.ALL )
        private List<MaintenanceModel> maintenances;

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

    public String getSpecialty()
    {
        return specialty;
    }

    public void setSpecialty( String specialty )
    {
        this.specialty = specialty;
    }
}
