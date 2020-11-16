package br.com.zup.proposta.microservices.contas.services;

import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Bloqueio;
import br.com.zup.proposta.microservices.contas.dtos.requests.BloquearCartaoBodyRequest;
import br.com.zup.proposta.microservices.contas.endpoints.BloquearCartaoEndpoint;

@Service
public class BloquearCartaoMicroService {

	private final Logger logger = LoggerFactory.getLogger(BloquearCartaoMicroService.class);

	@Autowired
	private BloquearCartaoEndpoint bloquearCartaoEndpoint; // 1

	// 1
	public String registrarBloqueio(@NotEmpty Bloqueio bloqueio) {

		String resultado;

		try { // 1

			String idCartao = bloqueio.getCartao().getId();

			BloquearCartaoBodyRequest bloquearCartaoBodyRequest = new BloquearCartaoBodyRequest();

			bloquearCartaoBodyRequest.setSistemaResponsavel(bloqueio.getSistemaResponsavel());

			logger.info("Iniciando bloqueio do cartao no sistema legado...");
			logger.warn("O conteudo do idCartão é: {}", idCartao);

			resultado = bloquearCartaoEndpoint.bloquearCartao(idCartao, bloquearCartaoBodyRequest);

			logger.info("O bloqueio foi realizado com sucesso!");

		} catch (Exception e) { // ?

			logger.info("O sistema legado de cartões recusou o seu bloqueio");
			logger.error(e.getLocalizedMessage());

			return "ERRO";

		}

		return resultado;
	}
}
