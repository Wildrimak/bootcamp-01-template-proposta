package br.com.zup.proposta.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.domain.repositories.PropostaRepository;

@RestController
@RequestMapping("/propostas")
public class AcompanharPropostaController {

	@Autowired
	private PropostaRepository propostaRepository; // 1

	@GetMapping("/{id}")
	public ResponseEntity<?> detalheCompra(@PathVariable String id) {

		Optional<Proposta> optionalProposta = propostaRepository.findById(id);

		// 1
		if (optionalProposta.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(optionalProposta.get());
	}

}
