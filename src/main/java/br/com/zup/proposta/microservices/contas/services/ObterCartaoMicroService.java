package br.com.zup.proposta.microservices.contas.services;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Cartao;
import br.com.zup.proposta.microservices.contas.endpoints.ObterCartaoEndpoint;

@Service
public class ObterCartaoMicroService {

	private final Logger logger = LoggerFactory.getLogger(ObterCartaoMicroService.class);

	@Autowired
	private ObterCartaoEndpoint obterCartaoEndpoint; // 1

	public Optional<Cartao> obterCartao(@NotNull String idProposta) { // 1

		logger.info("Chegando no ObterCartaoMicroService e executando o metodo de obterCartao");

		Cartao cartao;

		try { // 1

			logger.info("Tentando acessar serviço externo para obter cartão");
			cartao = obterCartaoEndpoint.getCartao(idProposta);

		} catch (Exception e) { // ?

			logger.info("O cartão da proposta de id {} ainda não foi criado", idProposta);
			return Optional.empty();

		}

		logger.info("Estado do objeto cartaoResponse: " + cartao);

		return Optional.of(cartao);
	}
}
