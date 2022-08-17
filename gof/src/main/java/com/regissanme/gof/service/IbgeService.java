package com.regissanme.gof.service;

import com.regissanme.gof.model.IbgeFrequenciaNome;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Consulta Pública à API Nomes do <a href="https://servicodados.ibge.gov.br/api/docs/nomes?versao=2#api-_">IBGE</a>,
 * onde mostra a frequência de nomes por década de nascimento.
 *
 * Quando a quantidade de ocorrências for suficientemente pequena a ponto de não permitir a
 * identificação delas, o IBGE não informa essa quantidade. No caso da API de Nomes,
 * a quantidade mínima de ocorrências para que seja divulgado os resultados é
 * de 10 por município, 15 por Unidade da Federação e 20 no Brasil.
 *
 * Projeto: gof
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 16/08/2022
 * Hora: 14:06
 */
@FeignClient(name = "ibge", url = "https://servicodados.ibge.gov.br/api/v2/censos/nomes")
public interface IbgeService {

    /**
     * Obtém a frequência de nascimentos por década para o nome consultado.
     *
     * @param nome O nome que será consultado na API do IBGE
     * @return Uma lista com as frequências do nome por década.
     */
    @GetMapping("/{nome}")
    List<IbgeFrequenciaNome> consultarNome(@PathVariable("nome") String nome);

}
