package br.com.zup.proposta.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.proposta.api.dtos.requests.PropostaRequest;
import br.com.zup.proposta.api.validators.CpfCnpjValidator;
import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.domain.services.CadastrarPropostaService;

@RestController
@RequestMapping("/propostas")
public class CadastrarPropostaController {

	@Autowired
	private CpfCnpjValidator cpfCnpjValidator; // 1

	@Autowired
	private CadastrarPropostaService cadastrarPropostaService; // 1

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(cpfCnpjValidator);
	}

	@PostMapping // 1
	public ResponseEntity<?> criarProposta(@Valid @RequestBody PropostaRequest request,
			UriComponentsBuilder uriComponentsBuilder) {

		Proposta proposta = request.toProposta(); // 1
		Proposta salva = cadastrarPropostaService.salvarPropostaRecebidaSemAnalise(proposta);
		Proposta avaliada = cadastrarPropostaService.avaliarElegibilidade(salva);
		
		return ResponseEntity
				.created(uriComponentsBuilder.path("/propostas/{id}").buildAndExpand(avaliada.getId()).toUri())
				.body(salva);

	}

}
