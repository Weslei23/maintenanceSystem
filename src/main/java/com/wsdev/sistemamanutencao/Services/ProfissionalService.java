package com.wsdev.sistemamanutencao.Services;

import com.wsdev.sistemamanutencao.Models.ProfissionalModel;
import com.wsdev.sistemamanutencao.Repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService
{
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public List<ProfissionalModel> listarTodos()
    {
        return profissionalRepository.findAll();
    }

    public Optional<ProfissionalModel> buscarPorId(Long id )
    {
        return profissionalRepository.findById( id );
    }

    public ProfissionalModel salvar( ProfissionalModel profissional )
    {
        return profissionalRepository.save( profissional );
    }

    public Optional<ProfissionalModel> atualizar( Long id, ProfissionalModel profissionalAtualizado )
    {
        return profissionalRepository.findById( id ).map( profissional ->
        {
            profissional.setNome( profissionalAtualizado.getNome() );
            profissional.setTelefone( profissionalAtualizado.getTelefone() );
            profissional.setEspecialidade( profissionalAtualizado.getEspecialidade() );
            return profissionalRepository.save( profissional );
        } );
    }

    public void deletar( Long id )
    {
        profissionalRepository.deleteById( id );
    }
}
