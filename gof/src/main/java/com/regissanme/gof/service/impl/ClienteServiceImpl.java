package com.regissanme.gof.service.impl;

import com.regissanme.gof.model.Cliente;
import com.regissanme.gof.model.IbgeFrequenciaNome;
import com.regissanme.gof.repository.ClienteRepository;
import com.regissanme.gof.service.ClienteService;
import com.regissanme.gof.service.IbgeFrequenciaNomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 13:58
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private IbgeFrequenciaNomeService frequenciaNomeService;


    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void inserir(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            return;
        }
        salvarClienteComFrequenciasDoNome(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Cliente clienteExiste = this.buscarPorId(id);
        if (clienteExiste != null) {
            salvarClienteComFrequenciasDoNome(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        Cliente cliente = this.buscarPorId(id);
        if (cliente != null) {
            clienteRepository.deleteById(id);
        }
    }

    private void salvarClienteComFrequenciasDoNome(Cliente cliente) {
        IbgeFrequenciaNome frequenciaNome = frequenciaNomeService.salvarFrequenciaDoNome(cliente);
        cliente.setIbgeFrequenciaNome(frequenciaNome);
        clienteRepository.save(cliente);
    }

}
