package com.cablecash.api.repository;

import com.cablecash.api.model.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByContaId(Long id);
    List<Pagamento> findByCartaoId(Long id);
}
