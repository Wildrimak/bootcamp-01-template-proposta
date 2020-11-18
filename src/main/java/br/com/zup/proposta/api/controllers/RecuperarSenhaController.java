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

import br.com.zup.proposta.api.dtos.responses.RecuperarSenhaResponse;
import br.com.zup.proposta.domain.models.Cartao;
import br.com.zup.proposta.domain.models.RecuperarSenhaCartao;
import br.com.zup.proposta.domain.repositories.CartaoRepository;
import br.com.zup.proposta.domain.services.RecuperarSenhaCartaoService;

@RestController
@RequestMapping("/cartoes/{id}/recuperarSenha")
public class RecuperarSenhaController {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private RecuperarSenhaCartaoService recuperarSenhaCartaoService;

	@PostMapping
	public ResponseEntity<?> recuperarSenha(HttpServletRequest httpServletRequest, @PathVariable String id,
			@RequestHeader(value = "User-Agent") String userAgent, UriComponentsBuilder uriComponentsBuilder) {

		Optional<Cartao> optional = cartaoRepository.findById(id);

		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Cartao cartao = optional.get();

		String remoteAddr = httpServletRequest.getRemoteAddr();

		RecuperarSenhaCartao recuperarSenhaCartao = new RecuperarSenhaCartao(cartao, remoteAddr, userAgent);

		RecuperarSenhaCartao save = recuperarSenhaCartaoService.save(recuperarSenhaCartao);

		return ResponseEntity.created(uriComponentsBuilder.path("/cartoes/{idCartao}/recuperarSenha/{idRecuperarSenha}")
				.buildAndExpand(cartao.getId(), save.getId()).toUri()).body(new RecuperarSenhaResponse(save));

	}
}
