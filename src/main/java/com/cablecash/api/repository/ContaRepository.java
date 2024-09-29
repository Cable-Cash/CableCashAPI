package com.cablecash.api.repository;

import com.cablecash.api.enums.EnumTipoConta;
import com.cablecash.api.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    List<Conta> findByClienteId(Long id);
    Optional<Conta> findByTipoConta(EnumTipoConta tipoConta);
}
