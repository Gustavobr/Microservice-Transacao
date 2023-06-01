package br.com.microservice_transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microservice_transacao.entity.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}
