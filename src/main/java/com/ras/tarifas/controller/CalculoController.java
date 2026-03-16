package com.ras.tarifas.controller;

import com.ras.tarifas.dto.CalculoRequestDTO;
import com.ras.tarifas.dto.CalculoResponseDTO;
import com.ras.tarifas.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculos")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @PostMapping
    public ResponseEntity<CalculoResponseDTO> calcular(@RequestBody CalculoRequestDTO dto) {
        
        CalculoResponseDTO resultado = calculoService.calcularTarifa(dto);

        return ResponseEntity.ok(resultado);
    }
}