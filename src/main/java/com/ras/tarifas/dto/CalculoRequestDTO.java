package com.ras.tarifas.dto;

import com.ras.tarifas.model.Categoria;

public class CalculoRequestDTO {

    private Long tabelaId;
    private Categoria categoria;
    private Integer consumo;

    public CalculoRequestDTO() {
    }

    public Long getTabelaId() {
        return tabelaId;
    }

    public void setTabelaId(Long tabelaId) {
        this.tabelaId = tabelaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }
}