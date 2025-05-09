package com.wsdev.sistemamanutencao.Services;

import com.wsdev.sistemamanutencao.Models.ManutencaoModel;
import com.wsdev.sistemamanutencao.Repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoService
{
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public List<ManutencaoModel> getAllMaintenances()
    {
        return manutencaoRepository.findAll();
    }

    public Optional<ManutencaoModel> buscarPorId( Long id )
    {
        return manutencaoRepository.findById( id );
    }

    public ManutencaoModel salvar( ManutencaoModel manutencao )
    {
        return manutencaoRepository.save( manutencao );
    }

    public Optional<ManutencaoModel> atualizar(Long id, ManutencaoModel manutencaoAtualizada )
    {
        return manutencaoRepository.findById( id ).map( manutencao ->
        {
            manutencao.setDataAgendada( manutencaoAtualizada.getDataAgendada() );
            manutencao.setDescricaoServico( manutencaoAtualizada.getDescricaoServico() );
            manutencao.setStatus( manutencaoAtualizada.getStatus() );
            manutencao.setCliente( manutencaoAtualizada.getCliente() );
            manutencao.setProfissional( manutencaoAtualizada.getProfissional() );
            return manutencaoRepository.save( manutencao );
        } );
    }

    public void deletar( Long id )
    {
        manutencaoRepository.deleteById( id );
    }
}
