package com.regissanme.gof.repository;

import com.regissanme.gof.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 13:57
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
