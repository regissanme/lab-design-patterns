package com.regissanme.gof.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 17:14
 */
@Entity
public class IbgeFrequenciaNomeDados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String periodo;
    private Integer frequencia;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private IbgeFrequenciaNome ibgeFrequenciaNome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }

    public IbgeFrequenciaNome getIbgeFrequenciaNome() {
        return ibgeFrequenciaNome;
    }

    public void setIbgeFrequenciaNome(IbgeFrequenciaNome ibgeFrequenciaNome) {
        this.ibgeFrequenciaNome = ibgeFrequenciaNome;
    }
}
