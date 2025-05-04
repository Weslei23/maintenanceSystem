package com.wsdev.sistemamanutencao.Controller;

import com.wsdev.sistemamanutencao.Models.ProfissionalModel;
import com.wsdev.sistemamanutencao.Repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController
{
    @Autowired
    private ProfissionalRepository profissionalRepository;

    @GetMapping
    public List<ProfissionalModel> listar()
    {
        return profissionalRepository.findAll();
    }

    @GetMapping( "/{id}" )
    public ProfissionalModel buscarPorId( @PathVariable Long id )
    {
        return profissionalRepository.findById( id ).orElse( null );
    }

    @PostMapping
    public ProfissionalModel criar( @RequestBody ProfissionalModel profissional )
    {
        return profissionalRepository.save( profissional );
    }

    @PutMapping( "/{id}" )
    public ProfissionalModel atualizar( @PathVariable Long id, @RequestBody ProfissionalModel atualizado )
    {
        return profissionalRepository.findById( id ).map( profissional ->
        {
            profissional.setNome( atualizado.getNome() );
            profissional.setTelefone( atualizado.getTelefone() );
            profissional.setEspecialidade( atualizado.getEspecialidade() );
            return profissionalRepository.save( profissional );
        } ).orElse( null );
    }

    @DeleteMapping( "/{id}" )
    public void deletar(@PathVariable Long id)
    {
        profissionalRepository.deleteById( id );
    }
}
