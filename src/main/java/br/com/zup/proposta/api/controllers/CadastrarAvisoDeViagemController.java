package br.com.zup.proposta.api.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.proposta.api.dtos.requests.AvisoViagemRequest;
import br.com.zup.proposta.domain.models.Aviso;
import br.com.zup.proposta.domain.models.Cartao;
import br.com.zup.proposta.domain.repositories.CartaoRepository;
import br.com.zup.proposta.domain.services.CadastrarAvisoDeViagemService;

@RestController
@RequestMapping("/cartoes/{idCartao}/avisos")
public class CadastrarAvisoDeViagemController {

	@Autowired
	private CadastrarAvisoDeViagemService avisoDeViagemService; // 1

	@Autowired
	private CartaoRepository cartaoRepository; // 1

	@PostMapping // 1
	public ResponseEntity<?> cadastrar(@Valid @RequestBody AvisoViagemRequest request,
			HttpServletRequest httpServletRequest, @PathVariable String idCartao,
			@RequestHeader(value = "User-Agent") String userAgent, UriComponentsBuilder uriComponentsBuilder) {

		Optional<Cartao> optional = cartaoRepository.findById(idCartao); // 1

		if (optional.isEmpty()) { // 1
			return ResponseEntity.notFound().build();
		}

		// 1
		Aviso aviso = request.toModel(httpServletRequest.getRemoteAddr(), userAgent);
		aviso.setCartao(optional.get());

		Aviso save = avisoDeViagemService.cadastrar(aviso);

		Map<String, String> response = new HashMap<>();

		response.put("id", save.getId());
		response.put("destino", save.getDestino());
		response.put("validoAte", save.getValidoAte().toString());
		response.put("dataAviso", save.getDataAviso().toString());
		response.put("ipUsuario", save.getIpUsuario());
		response.put("userAgent", save.getUserAgent());
		response.put("idCartao", save.getCartao().getId());

		return ResponseEntity.created(uriComponentsBuilder.path("/cartoes/{idCartao}/avisos/{id}")
				.buildAndExpand(optional.get().getId(), save.getId()).toUri()).body(response);

	}
}
