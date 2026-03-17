package com.ras.tarifas.dto;

import com.ras.tarifas.model.Categoria;

public class CalculoRequestDTO {

    private Categoria categoria;
    private Integer consumo;

    public CalculoRequestDTO() {
    }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Integer getConsumo() { return consumo; }
    public void setConsumo(Integer consumo) { this.consumo = consumo; }
}