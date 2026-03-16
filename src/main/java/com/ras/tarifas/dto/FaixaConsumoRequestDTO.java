package com.ras.tarifas.dto;

import com.ras.tarifas.model.Categoria;
import java.math.BigDecimal;

public class FaixaConsumoRequestDTO {

    private Categoria categoria;
    private Integer inicio;
    private Integer fim;
    private BigDecimal valorUnitario;

    public FaixaConsumoRequestDTO() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public Integer getFim() {
        return fim;
    }

    public void setFim(Integer fim) {
        this.fim = fim;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}