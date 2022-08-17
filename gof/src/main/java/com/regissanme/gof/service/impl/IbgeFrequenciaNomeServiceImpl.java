package com.regissanme.gof.service.impl;

import com.regissanme.gof.model.Cliente;
import com.regissanme.gof.model.IbgeFrequenciaNome;
import com.regissanme.gof.repository.IbgeFrequenciaNomeRepository;
import com.regissanme.gof.service.IbgeFrequenciaNomeService;
import com.regissanme.gof.service.IbgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Optional<IbgeFrequenciaNome> byNome = ibgeFrequenciaNomeRepository.findByNome(nomeCliente);
        if (byNome.isPresent()) {
            System.out.println("Salvo no banco: " + byNome.get());
        } else {
            System.out.println("Não encontrou o nome: " + nomeCliente + " no BD.");
        }

        return ibgeFrequenciaNomeRepository.findByNome(nomeCliente).orElseGet(() -> {
            System.out.println("Entrou para salvar a frequencia...");
            List<IbgeFrequenciaNome> list = ibgeService.consultarNome(nomeCliente);
            if (list.size() != 1) {
                return null;
            }
            for (IbgeFrequenciaNome nome : list) {
                System.out.println("Nome: " + nome);
            }
            IbgeFrequenciaNome paraSalvar = list.get(0);
            paraSalvar.getRes().forEach(dado -> dado.setIbgeFrequenciaNome(paraSalvar));
            return ibgeFrequenciaNomeRepository.save(paraSalvar);
        });
    }

}
