package com.ras.tarifas.dto;

import java.math.BigDecimal;

public class CalculoResponseDTO {

    private BigDecimal valorTotal;

    public CalculoResponseDTO() {
    }

    public CalculoResponseDTO(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}