package com.wsdev.sistemamanutencao.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "tb_profissional" )
public class ProfissionalModel
{
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        private Long id;

        @Column( nullable = false )
        private String nome;

        @Column( nullable = false )
        private String telefone;

        @Column( nullable = false )
        private String especialidade;

        @OneToMany( mappedBy = "profissional", cascade = CascadeType.ALL )
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

    public String getEspecialidade()
    {
        return especialidade;
    }

    public void setEspecialidade( String especialidade )
    {
        this.especialidade = especialidade;
    }
}
