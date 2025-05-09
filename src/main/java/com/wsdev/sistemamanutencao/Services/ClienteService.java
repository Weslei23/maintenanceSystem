package com.wsdev.sistemamanutencao.Services;

import com.wsdev.sistemamanutencao.Models.ClienteModel;
import com.wsdev.sistemamanutencao.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> getAllClientes()
    {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> buscarPorId( Long id )
    {
        return clienteRepository.findById( id );
    }

    public ClienteModel addNewCliente(ClienteModel cliente )
    {
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteModel> atualizar( Long id, ClienteModel clienteAtualizado )
    {
        return clienteRepository.findById( id ).map( cliente ->
        {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            return clienteRepository.save( cliente );
        } );
    }

    public void deletar( Long id )
    {
        clienteRepository.deleteById( id );
    }
}
