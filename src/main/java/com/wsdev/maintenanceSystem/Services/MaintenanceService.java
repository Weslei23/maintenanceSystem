package com.wsdev.maintenanceSystem.Services;

import com.wsdev.maintenanceSystem.Models.CustomerModel;
import com.wsdev.maintenanceSystem.Models.MaintenanceModel;
import com.wsdev.maintenanceSystem.Repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService
{
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<MaintenanceModel> getMaintenances()
    {
        return maintenanceRepository.findAll();
    }

    public Optional<MaintenanceModel> getMaintenanceById( Long id )
    {
        return maintenanceRepository.findById( id );
    }

    public MaintenanceModel addNewMaintenance( MaintenanceModel maintenance )
    {
        return maintenanceRepository.save( maintenance );
    }

    public MaintenanceModel updateMaintenance( Long id, MaintenanceModel maintenanceUpdated )
    {
        MaintenanceModel maintenance = maintenanceRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Manutenção não encontrada" ) );

        maintenance.setScheduledDate( maintenanceUpdated.getScheduledDate() );
        maintenance.setDescriptionService( maintenanceUpdated.getDescriptionService() );
        maintenance.setStatus( maintenanceUpdated.getStatus() );
        maintenance.setCustomer( maintenanceUpdated.getCustomer() );
        maintenance.setEmployee( maintenanceUpdated.getEmployee() );

        return maintenanceRepository.save( maintenance );
    }

    public void deleteMaintenanceById( Long id )
    {
        maintenanceRepository.deleteById( id );
    }
}
