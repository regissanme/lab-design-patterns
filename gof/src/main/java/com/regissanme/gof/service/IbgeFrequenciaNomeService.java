package com.regissanme.gof.service;

import com.regissanme.gof.model.Cliente;
import com.regissanme.gof.model.IbgeFrequenciaNome;
import org.springframework.stereotype.Service;

/**
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 22:47
 */


public interface IbgeFrequenciaNomeService {

    IbgeFrequenciaNome salvarFrequenciaDoNome(Cliente cliente);
}
