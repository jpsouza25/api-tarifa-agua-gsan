package com.ras.tarifas.dto;

import java.util.List;

public class TabelaTarifariaRequestDTO {

    private String nome;
    private List<FaixaConsumoRequestDTO> faixas;

    public TabelaTarifariaRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<FaixaConsumoRequestDTO> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<FaixaConsumoRequestDTO> faixas) {
        this.faixas = faixas;
    }
}