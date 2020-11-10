package br.com.zup.proposta.domain.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.microservices.contas.services.NovoCartaoMicroService;

@Service
public class SolicitarCartaoEmSegundoPlanoService {

	private final Logger logger = LoggerFactory.getLogger(SolicitarCartaoEmSegundoPlanoService.class);

	@Autowired
	private NovoCartaoMicroService novoCartaoMicroService; // 1

	@Async
	public void executar(@NotNull @Valid Proposta proposta) { // 1

		logger.info("Iniciando execução assincrona da criacao de cartão");

		novoCartaoMicroService.criarCartao(proposta);

	}

}
