package br.com.zup.proposta.domain.services;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.domain.models.StatusProposta;
import br.com.zup.proposta.domain.repositories.PropostaRepository;
import br.com.zup.proposta.microservices.avaliacaofinanceira.services.AnaliseFinanceiraMicroService;

@Service
public class CadastrarPropostaService {

	@Autowired
	private PropostaRepository propostaRepository; // 1

	@Autowired
	private AnaliseFinanceiraMicroService analiseFinanceiraMicroService; // 1

	@Transactional
	public Proposta salvarPropostaRecebidaSemAnalise(Proposta proposta) { // 1

		Optional<Proposta> optionalProposta = propostaRepository.findByDocumento(proposta.getDocumento());

		if (optionalProposta.isPresent()) { // 1
			throw new IllegalStateException("Esse documento já foi cadastrado!");
		}

		return propostaRepository.save(proposta);

	}

	public Proposta avaliarElegibilidade(@NotNull @Valid Proposta proposta) {

		// 1
		StatusProposta statusProposta = analiseFinanceiraMicroService.avaliaElegibilidade(proposta);
		proposta.setStatusProposta(statusProposta);

		return proposta;
	}

}
