package com.ras.tarifas.repository;

import com.ras.tarifas.model.TabelaTarifaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaTarifariaRepository extends JpaRepository<TabelaTarifaria, Long> {

}