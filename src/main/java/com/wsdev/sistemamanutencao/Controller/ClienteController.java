package com.wsdev.sistemamanutencao.Controller;

import com.wsdev.sistemamanutencao.Models.ClienteModel;
import com.wsdev.sistemamanutencao.Repository.ClienteRepository;
import com.wsdev.sistemamanutencao.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/clientes" )
public class ClienteController
{
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String getClientes( Model model )
    {
        List<ClienteModel> list = clienteService.getAllClientes();
        model.addAttribute( "clientes", list );
        return "clienteList" ;
    }

    @GetMapping( "/{id}" )
    public ClienteModel buscarPorId( @PathVariable Long id )
    {
        return clienteRepository.findById( id ).orElse( null );
    }

    @PostMapping
    public ClienteModel criar( @RequestBody ClienteModel cliente )
    {
        return clienteRepository.save( cliente );
    }

    @PutMapping("/{id}")
    public ClienteModel atualizar( @PathVariable Long id, @RequestBody ClienteModel clienteAtualizado )
    {
        return clienteRepository.findById( id ).map( cliente ->
        {
            cliente.setNome( clienteAtualizado.getNome() );
            cliente.setTelefone( clienteAtualizado.getTelefone() );
            cliente.setEmail( clienteAtualizado.getEmail() );
            cliente.setEndereco( clienteAtualizado.getEndereco() );
            return clienteRepository.save( cliente );
        } ).orElse( null );
    }

    @DeleteMapping( "/{id}" )
    public void deletar( @PathVariable Long id )
    {
        clienteRepository.deleteById( id );
    }
}
