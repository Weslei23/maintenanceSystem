package com.wsdev.sistemamanutencao.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "tb_cliente")
public class ClienteModel
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private String nome;

    @Column( nullable = false )
    private String telefone;

    @Column( nullable = false )
    private String email;

    @Column( nullable = false )
    private String endereco;

    @OneToMany( mappedBy = "cliente", cascade = CascadeType.ALL )
    private List<ManutencaoModel> manutencoes;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public List<ManutencaoModel> getManutencoes()
    {
        return manutencoes;
    }

    public void setManutencoes( List<ManutencaoModel> manutencoes )
    {
        this.manutencoes = manutencoes;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco( String endereco )
    {
        this.endereco = endereco;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone( String telefone )
    {
        this.telefone = telefone;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome( String nome )
    {
        this.nome = nome;
    }
}
