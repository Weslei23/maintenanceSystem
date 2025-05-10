package com.wsdev.sistemamanutencao.Controller;

import com.wsdev.sistemamanutencao.Models.MaintenanceModel;
import com.wsdev.sistemamanutencao.Repository.MaintenanceRepository;
import com.wsdev.sistemamanutencao.Services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/maintenances" )
public class MaintenanceController
{
    @Autowired
    private MaintenanceRepository maintenanceRepository;
    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public String getMaintenances( Model model )
    {
        List<MaintenanceModel> list = maintenanceService.getMaintenances();
        model.addAttribute( "maintenances", list );
        return "maintenanceList" ;
    }

    @GetMapping( "/{id}" )
    public MaintenanceModel getMaintenanceById( @PathVariable Long id )
    {
        return maintenanceService.getMaintenanceById( id ).orElse( null );
    }

    @PostMapping( "/addmaintenance" )
    public MaintenanceModel addNewMaintenance( @RequestBody MaintenanceModel maintenance )
    {
        return maintenanceService.addNewMaintenance( maintenance );
    }

    @PutMapping( "/{id}" )
    public MaintenanceModel updateMaintenance( @PathVariable Long id, @RequestBody MaintenanceModel maintenanceUpdated )
    {
        return maintenanceService.updateMaintenance( id, maintenanceUpdated );
    }

    @DeleteMapping(  "/{id}" )
    public void deleteMaintenanceById( @PathVariable Long id )
    {
        maintenanceService.deleteMaintenanceById( id );
    }
}
