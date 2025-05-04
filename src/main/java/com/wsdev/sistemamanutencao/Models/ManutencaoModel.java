package com.wsdev.sistemamanutencao.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table( name = "tb_manutencao")
public class ManutencaoModel
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private LocalDate dataAgendada;

    @Enumerated( EnumType.STRING )
    private StatusModel status;

    @Column( nullable = false )
    private String descricaoServico;

    @ManyToOne
    @JoinColumn( name = "cliente_id" )
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn( name = "profissional_id" )
    private ProfissionalModel profissional;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public ClienteModel getCliente()
    {
        return cliente;
    }

    public void setCliente( ClienteModel cliente )
    {
        this.cliente = cliente;
    }

    public String getDescricaoServico()
    {
        return descricaoServico;
    }

    public void setDescricaoServico( String descricaoServico )
    {
        this.descricaoServico = descricaoServico;
    }

    public LocalDate getDataAgendada()
    {
        return dataAgendada;
    }

    public void setDataAgendada( LocalDate dataAgendada )
    {
        this.dataAgendada = dataAgendada;
    }

    public StatusModel getStatus()
    {
        return status;
    }

    public void setStatus( StatusModel status )
    {
        this.status = status;
    }

    public ProfissionalModel getProfissional()
    {
        return profissional;
    }

    public void setProfissional( ProfissionalModel profissional )
    {
        this.profissional = profissional;
    }
}
