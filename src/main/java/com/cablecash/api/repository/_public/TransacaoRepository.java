package com.cablecash.api.repository._public;

import com.cablecash.api.model.entity._public.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
//    List<Transacao> findByContaOrigemId(Long idContaOrigem);
//    List<Transacao> findByContaDestinoId(Long idConta);
}
