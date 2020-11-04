package br.com.zup.proposta.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.domain.repositories.PropostaRepository;

@Service
public class PropostaService {

	@Autowired
	private PropostaRepository propostaRepository; // 1

	public Proposta criar(Proposta proposta) { // 2
		
		Optional<Proposta> optionalProposta = propostaRepository.findByDocumento(proposta.getDocumento());

		if (optionalProposta.isPresent()) { // 3
			throw new IllegalStateException("Esse documento já foi cadastrado!");
		}

		return propostaRepository.save(proposta);

	}

	
}
