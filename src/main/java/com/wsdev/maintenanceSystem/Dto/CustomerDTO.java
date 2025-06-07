package com.wsdev.maintenanceSystem.Dto;

import com.wsdev.maintenanceSystem.Models.AddressModel;
import com.wsdev.maintenanceSystem.Models.MaintenanceModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CustomerDTO( String name, String telephone, String email, AddressModel address, List<MaintenanceModel> maintenances )
{

}
