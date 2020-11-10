package br.com.zup.proposta.microservices.contas.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.microservices.contas.dtos.requests.NovoCartaoRequest;
import br.com.zup.proposta.microservices.contas.endpoints.NovoCartaoEndpoint;

@Service
public class NovoCartaoMicroService {

	private final Logger logger = LoggerFactory.getLogger(NovoCartaoMicroService.class);

	@Autowired
	private NovoCartaoEndpoint novoCartaoEndpoint;

	public void criarCartao(@NotNull @Valid Proposta proposta) {

		logger.info("Chegando no NovoCartaoMicroService executando o metodo de criarCartao");
		String cartao = novoCartaoEndpoint.criarCartao(new NovoCartaoRequest(proposta));
		logger.info("Estado do objeto cartaoResponse: " + cartao);

	}
}
