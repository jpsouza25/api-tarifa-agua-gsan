package com.ras.tarifas.service;

import com.ras.tarifas.dto.CalculoRequestDTO;
import com.ras.tarifas.dto.CalculoResponseDTO;
import com.ras.tarifas.model.FaixaConsumo;
import com.ras.tarifas.model.TabelaTarifaria;
import com.ras.tarifas.repository.TabelaTarifariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculoService {

    @Autowired
    private TabelaTarifariaRepository tabelaRepository;

    public CalculoResponseDTO calcularTarifa(CalculoRequestDTO dto) {
        
        TabelaTarifaria tabela = tabelaRepository.findFirstByOrderByIdDesc();
        if (tabela == null) {
            throw new RuntimeException("Nenhuma tabela encontrada no sistema!");
        }

        List<FaixaConsumo> faixasDaCategoria = tabela.getFaixas().stream()
                .filter(faixa -> faixa.getCategoria() == dto.getCategoria())
                .sorted(Comparator.comparing(FaixaConsumo::getInicio))
                .collect(Collectors.toList());

        BigDecimal valorTotal = BigDecimal.ZERO;
        int consumoRestante = dto.getConsumo();
        
        List<CalculoResponseDTO.DetalhamentoDTO> listaDetalhamento = new ArrayList<>();

        for (FaixaConsumo faixa : faixasDaCategoria) {
            if (consumoRestante <= 0) break;

            int capacidadeDaFaixa;
            if (faixa.getInicio() == 0) {
                capacidadeDaFaixa = faixa.getFim(); 
            } else {
                capacidadeDaFaixa = faixa.getFim() - faixa.getInicio() + 1;
            }

            int volumeFaturadoNaFaixa = Math.min(consumoRestante, capacidadeDaFaixa);
            BigDecimal valorDestaFaixa = faixa.getValorUnitario().multiply(new BigDecimal(volumeFaturadoNaFaixa));

            valorTotal = valorTotal.add(valorDestaFaixa);
            consumoRestante -= volumeFaturadoNaFaixa;

            CalculoResponseDTO.FaixaDTO faixaDTO = new CalculoResponseDTO.FaixaDTO();
            faixaDTO.setInicio(faixa.getInicio());
            faixaDTO.setFim(faixa.getFim());

            CalculoResponseDTO.DetalhamentoDTO detalhe = new CalculoResponseDTO.DetalhamentoDTO();
            detalhe.setFaixa(faixaDTO);
            detalhe.setM3Cobrados(volumeFaturadoNaFaixa);
            detalhe.setValorUnitario(faixa.getValorUnitario());
            detalhe.setSubtotal(valorDestaFaixa);

            listaDetalhamento.add(detalhe);
        }

        CalculoResponseDTO response = new CalculoResponseDTO();
        response.setCategoria(dto.getCategoria().name());
        response.setConsumoTotal(dto.getConsumo());
        response.setValorTotal(valorTotal);
        response.setDetalhamento(listaDetalhamento);

        return response;
    }
}