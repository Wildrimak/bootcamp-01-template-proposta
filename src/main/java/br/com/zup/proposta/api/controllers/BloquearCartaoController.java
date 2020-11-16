package br.com.zup.proposta.api.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.proposta.api.dtos.responses.BloqueioResponse;
import br.com.zup.proposta.domain.models.Bloqueio;
import br.com.zup.proposta.domain.models.Cartao;
import br.com.zup.proposta.domain.repositories.CartaoRepository;
import br.com.zup.proposta.domain.services.BloquearCartaoService;

@RestController
@RequestMapping("/cartoes/{id}/bloqueios")
public class BloquearCartaoController {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private BloquearCartaoService bloquearCartaoService;

	@PostMapping
	public ResponseEntity<?> bloqueie(HttpServletRequest httpServletRequest, @PathVariable String id,
			@RequestHeader(value = "User-Agent") String userAgent, UriComponentsBuilder uriComponentsBuilder) {

		Optional<Cartao> optional = cartaoRepository.findById(id);

		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Cartao cartao = optional.get();

		String remoteAddr = httpServletRequest.getRemoteAddr();
		Bloqueio bloqueio = new Bloqueio(remoteAddr, userAgent, cartao);

		Bloqueio bloqueado = bloquearCartaoService.registrar(bloqueio);

		return ResponseEntity
				.created(uriComponentsBuilder.path("/bloqueios/{id}").buildAndExpand(bloqueado.getId()).toUri())
				.body(new BloqueioResponse(bloqueado));

	}

}
