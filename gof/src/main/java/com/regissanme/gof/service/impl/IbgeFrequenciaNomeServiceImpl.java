package com.regissanme.gof.service.impl;

import com.regissanme.gof.model.Cliente;
import com.regissanme.gof.model.IbgeFrequenciaNome;
import com.regissanme.gof.repository.IbgeFrequenciaNomeRepository;
import com.regissanme.gof.service.IbgeFrequenciaNomeService;
import com.regissanme.gof.service.IbgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 22:48
 */
@Service
public class IbgeFrequenciaNomeServiceImpl implements IbgeFrequenciaNomeService {

    @Autowired
    private IbgeService ibgeService;

    @Autowired
    private IbgeFrequenciaNomeRepository ibgeFrequenciaNomeRepository;


    @Override
    public IbgeFrequenciaNome salvarFrequenciaDoNome(Cliente cliente) {
        String nomeCliente = cliente.getNome().split(" ")[0].toUpperCase();

        return ibgeFrequenciaNomeRepository.findByNome(nomeCliente).orElseGet(() -> {

            List<IbgeFrequenciaNome> listaDeFrequenciasDoNome = ibgeService.consultarNome(nomeCliente);
            if (listaDeFrequenciasDoNome.size() != 1) {
                return null;
            }

            IbgeFrequenciaNome paraSalvar = listaDeFrequenciasDoNome.get(0);
            paraSalvar.getRes().forEach(dado -> dado.setIbgeFrequenciaNome(paraSalvar));
            return ibgeFrequenciaNomeRepository.save(paraSalvar);
        });
    }

}
