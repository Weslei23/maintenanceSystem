package com.wsdev.maintenanceSystem.Dto;

import com.wsdev.maintenanceSystem.Models.MaintenanceModel;

import java.util.List;

public record EmployeeDTO( String name, String telephone, String specialty, List<MaintenanceModel> maintenances )
{

}
