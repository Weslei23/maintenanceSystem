package com.wsdev.sistemamanutencao.Controller;

import com.wsdev.sistemamanutencao.Models.ClienteModel;
import com.wsdev.sistemamanutencao.Models.ManutencaoModel;
import com.wsdev.sistemamanutencao.Repository.ManutencaoRepository;
import com.wsdev.sistemamanutencao.Services.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/manutencoes" )
public class ManutencaoController
{
    @Autowired
    private ManutencaoRepository manutencaoRepository;
    @Autowired
    private ManutencaoService manutencaoService;

    @GetMapping
    public String getMaintenances( Model model )
    {
        List<ManutencaoModel> list = manutencaoService.getAllMaintenances();
        model.addAttribute( "maintenances", list );
        return "maintenanceList" ;
    }

    @GetMapping( "/{id}" )
    public ManutencaoModel buscarPorId( @PathVariable Long id )
    {
        return manutencaoRepository.findById( id ).orElse( null );
    }

    @PostMapping
    public ManutencaoModel criar( @RequestBody ManutencaoModel manutencao )
    {
        return manutencaoRepository.save( manutencao );
    }

    @PutMapping( "/{id}" )
    public ManutencaoModel atualizar( @PathVariable Long id, @RequestBody ManutencaoModel atualizada )
    {
        return manutencaoRepository.findById( id ).map(manutencao ->
        {
            manutencao.setDataAgendada( atualizada.getDataAgendada() );
            manutencao.setDescricaoServico( atualizada.getDescricaoServico() );
            manutencao.setStatus( atualizada.getStatus() );
            manutencao.setCliente( atualizada.getCliente() );
            manutencao.setProfissional( atualizada.getProfissional() );
            return manutencaoRepository.save( manutencao );
        } ).orElse( null );
    }

    @DeleteMapping(  "/{id}" )
    public void deletar( @PathVariable Long id )
    {
        manutencaoRepository.deleteById( id );
    }
}
