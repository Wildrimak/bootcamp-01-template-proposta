package br.com.zup.proposta.domain.services;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.RecuperarSenhaCartao;
import br.com.zup.proposta.domain.repositories.RecuperarSenhaCartaoRepository;

@Service
public class RecuperarSenhaCartaoService {

	@Autowired
	private RecuperarSenhaCartaoRepository recuperarSenhaCartaoRepository;

	@Transactional
	public RecuperarSenhaCartao save(@NotNull RecuperarSenhaCartao recuperarSenhaCartao) {
		return recuperarSenhaCartaoRepository.save(recuperarSenhaCartao);
	}

}
