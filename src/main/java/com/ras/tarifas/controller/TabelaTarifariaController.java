package com.ras.tarifas.controller;

import com.ras.tarifas.dto.TabelaTarifariaRequestDTO;
import com.ras.tarifas.model.TabelaTarifaria;
import com.ras.tarifas.repository.TabelaTarifariaRepository;
import com.ras.tarifas.service.TabelaTarifariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tabelas-tarifarias")
public class TabelaTarifariaController {

    @Autowired
    private TabelaTarifariaService service;

    @Autowired
    private TabelaTarifariaRepository tabelaRepository;

    @PostMapping
    public ResponseEntity<TabelaTarifaria> criarTabela(@RequestBody TabelaTarifariaRequestDTO dto) {
        TabelaTarifaria tabelaCriada = service.criarTabelaCompleta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tabelaCriada);
    }

    @GetMapping
    public ResponseEntity<List<TabelaTarifaria>> listarTabelas() {
        List<TabelaTarifaria> lista = tabelaRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTabela(@PathVariable Long id) {
        
        if (!tabelaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tabelaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}