package com.regissanme.gof.model;

import javax.persistence.*;

/**
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 13:56
 */
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private IbgeFrequenciaNome ibgeFrequenciaNome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public IbgeFrequenciaNome getIbgeFrequenciaNome() {
        return ibgeFrequenciaNome;
    }

    public void setIbgeFrequenciaNome(IbgeFrequenciaNome ibgeFrequenciaNome) {
        this.ibgeFrequenciaNome = ibgeFrequenciaNome;
    }
}
