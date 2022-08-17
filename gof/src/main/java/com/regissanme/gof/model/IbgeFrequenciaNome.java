package com.regissanme.gof.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 14:22
 */
@Entity
public class IbgeFrequenciaNome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String localidade;
//    private String sexo;


    @OneToMany(mappedBy = "ibgeFrequenciaNome", cascade = CascadeType.ALL)
    private List<IbgeFrequenciaNomeDados> res = new ArrayList<>();


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

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public List<IbgeFrequenciaNomeDados> getRes() {
        return res;
    }

    public void setRes(List<IbgeFrequenciaNomeDados> res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "IbgeFrequenciaNome{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", localidade='" + localidade + '\'' +
//                ", sexo='" + sexo + '\'' +
                ", res=" + res +
                '}';
    }


    private static class Res {

        private Long id;
        private String periodo;
        private Integer frequencia;

        @ManyToOne
        private IbgeFrequenciaNome ibgeFrequenciaNome;

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

        @Override
        public String toString() {
            return "Res{" +
                    "periodo='" + periodo + '\'' +
                    ", frequencia=" + frequencia +
                    '}';
        }
    }
}
