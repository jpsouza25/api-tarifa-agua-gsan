package com.ras.tarifas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tabela_tarifaria")
public class TabelaTarifaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "tabelaTarifaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FaixaConsumo> faixas;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<FaixaConsumo> getFaixas() { return faixas; }
    public void setFaixas(List<FaixaConsumo> faixas) { this.faixas = faixas; }
}