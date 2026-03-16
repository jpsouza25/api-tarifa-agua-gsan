package com.ras.tarifas.service;

import com.ras.tarifas.dto.CalculoRequestDTO;
import com.ras.tarifas.dto.CalculoResponseDTO;
import com.ras.tarifas.model.FaixaConsumo;
import com.ras.tarifas.model.TabelaTarifaria;
import com.ras.tarifas.repository.TabelaTarifariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculoService {

    @Autowired
    private TabelaTarifariaRepository tabelaRepository;

    public CalculoResponseDTO calcularTarifa(CalculoRequestDTO dto) {

        TabelaTarifaria tabela = tabelaRepository.findById(dto.getTabelaId())
                .orElseThrow(() -> new RuntimeException("Tabela não encontrada!"));

        List<FaixaConsumo> faixasDaCategoria = tabela.getFaixas().stream()
                .filter(faixa -> faixa.getCategoria() == dto.getCategoria())
                .sorted(Comparator.comparing(FaixaConsumo::getInicio))
                .collect(Collectors.toList());

        BigDecimal valorTotal = BigDecimal.ZERO;
        int consumoRestante = dto.getConsumo();

        for (FaixaConsumo faixa : faixasDaCategoria) {

            if (consumoRestante <= 0) {
                break;
            }

            int capacidadeDaFaixa;
            if (faixa.getInicio() == 0) {
                capacidadeDaFaixa = faixa.getFim();
            } else {
                capacidadeDaFaixa = faixa.getFim() - faixa.getInicio() + 1;
            }

            int volumeFaturadoNaFaixa = Math.min(consumoRestante, capacidadeDaFaixa);
            BigDecimal valorDestaFaixa = faixa.getValorUnitario()
                    .multiply(new BigDecimal(volumeFaturadoNaFaixa));

            valorTotal = valorTotal.add(valorDestaFaixa);

            consumoRestante -= volumeFaturadoNaFaixa;
        }
        return new CalculoResponseDTO(valorTotal);
    }
}