package com.cablecash.api.repository._public;

import com.cablecash.api.model.entity._public.ChavePIX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChavePIXRepository extends JpaRepository<ChavePIX, Long> {
}
