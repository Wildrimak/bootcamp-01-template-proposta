package br.com.zup.proposta.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.proposta.domain.models.RecuperarSenhaCartao;

public interface RecuperarSenhaCartaoRepository extends JpaRepository<RecuperarSenhaCartao, String> {

}
