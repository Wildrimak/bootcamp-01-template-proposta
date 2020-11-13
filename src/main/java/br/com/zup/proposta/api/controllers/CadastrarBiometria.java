package br.com.zup.proposta.api.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.proposta.api.dtos.requests.BiometriaRequest;
import br.com.zup.proposta.api.dtos.responses.BiometriaResponse;
import br.com.zup.proposta.domain.models.Biometria;
import br.com.zup.proposta.domain.models.Cartao;
import br.com.zup.proposta.domain.repositories.CartaoRepository;
import br.com.zup.proposta.domain.services.CadastrarBiometriaService;

@RestController
@RequestMapping("/cartoes/{id}")
public class CadastrarBiometria {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private CadastrarBiometriaService cadastrarBiometriaService;

	@PostMapping("/biometrias")
	public ResponseEntity<?> cadastrarBiometria(@Valid @RequestBody BiometriaRequest biometriaRequest,
			@PathVariable String id, UriComponentsBuilder uriComponentsBuilder) {

		Optional<Cartao> optional = cartaoRepository.findById(id);

		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Cartao cartao = optional.get();
		Biometria biometria = biometriaRequest.toModel();

		biometria.setCartao(cartao);

		Biometria salva = cadastrarBiometriaService.salvar(biometria);

		return ResponseEntity
				.created(uriComponentsBuilder.path("/biometrias/{id}").buildAndExpand(salva.getId()).toUri())
				.body(new BiometriaResponse(salva));
	}

}
