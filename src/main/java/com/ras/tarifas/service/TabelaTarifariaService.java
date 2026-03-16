package com.ras.tarifas.service;

import com.ras.tarifas.dto.FaixaConsumoRequestDTO;
import com.ras.tarifas.dto.TabelaTarifariaRequestDTO;
import com.ras.tarifas.model.FaixaConsumo;
import com.ras.tarifas.model.TabelaTarifaria;
import com.ras.tarifas.repository.FaixaConsumoRepository;
import com.ras.tarifas.repository.TabelaTarifariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TabelaTarifariaService {

    @Autowired
    private TabelaTarifariaRepository tabelaRepository;

    @Autowired
    private FaixaConsumoRepository faixaRepository;

    @Transactional
    public TabelaTarifaria criarTabelaCompleta(TabelaTarifariaRequestDTO dto) {
        
        TabelaTarifaria novaTabela = new TabelaTarifaria();
        novaTabela.setNome(dto.getNome());
        
        novaTabela = tabelaRepository.save(novaTabela);

        for (FaixaConsumoRequestDTO faixaDto : dto.getFaixas()) {
            
            FaixaConsumo faixa = new FaixaConsumo();
            faixa.setCategoria(faixaDto.getCategoria());
            faixa.setInicio(faixaDto.getInicio());
            faixa.setFim(faixaDto.getFim());
            faixa.setValorUnitario(faixaDto.getValorUnitario());
            faixa.setTabelaTarifaria(novaTabela);

            faixaRepository.save(faixa);
        }

        return novaTabela;
    }
}