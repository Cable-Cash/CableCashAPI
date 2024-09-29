package com.cablecash.api.repository;

import com.cablecash.api.model.entity.ChavePIX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChavePIXRepository extends JpaRepository<ChavePIX, Long> {

    List<ChavePIX> findByContaId(Long id);
    List<ChavePIX> findByClienteId(Long id);
}
