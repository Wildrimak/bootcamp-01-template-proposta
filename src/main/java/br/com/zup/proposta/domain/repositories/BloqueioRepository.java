package br.com.zup.proposta.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.proposta.domain.models.Bloqueio;

public interface BloqueioRepository extends JpaRepository<Bloqueio, String> {

}
