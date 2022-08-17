package com.regissanme.gof.repository;

import com.regissanme.gof.model.IbgeFrequenciaNome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 15:25
 */
@Repository
public interface IbgeFrequenciaNomeRepository extends CrudRepository<IbgeFrequenciaNome, Long> {

    Optional<IbgeFrequenciaNome> findByNome(String nome);
}
