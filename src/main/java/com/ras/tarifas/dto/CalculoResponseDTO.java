package com.ras.tarifas.dto;

import java.math.BigDecimal;
import java.util.List;

public class CalculoResponseDTO {

    private String categoria;
    private Integer consumoTotal;
    private BigDecimal valorTotal;
    private List<DetalhamentoDTO> detalhamento;

    public CalculoResponseDTO() {}

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getConsumoTotal() { return consumoTotal; }
    public void setConsumoTotal(Integer consumoTotal) { this.consumoTotal = consumoTotal; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public List<DetalhamentoDTO> getDetalhamento() { return detalhamento; }
    public void setDetalhamento(List<DetalhamentoDTO> detalhamento) { this.detalhamento = detalhamento; }

    public static class DetalhamentoDTO {
        private FaixaDTO faixa;
        private Integer m3Cobrados;
        private BigDecimal valorUnitario;
        private BigDecimal subtotal;

        public FaixaDTO getFaixa() { return faixa; }
        public void setFaixa(FaixaDTO faixa) { this.faixa = faixa; }

        public Integer getM3Cobrados() { return m3Cobrados; }
        public void setM3Cobrados(Integer m3Cobrados) { this.m3Cobrados = m3Cobrados; }

        public BigDecimal getValorUnitario() { return valorUnitario; }
        public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }

        public BigDecimal getSubtotal() { return subtotal; }
        public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    }

    public static class FaixaDTO {
        private Integer inicio;
        private Integer fim;

        public Integer getInicio() { return inicio; }
        public void setInicio(Integer inicio) { this.inicio = inicio; }

        public Integer getFim() { return fim; }
        public void setFim(Integer fim) { this.fim = fim; }
    }
}