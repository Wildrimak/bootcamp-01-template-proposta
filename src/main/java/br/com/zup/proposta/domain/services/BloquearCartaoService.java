package br.com.zup.proposta.domain.services;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Bloqueio;
import br.com.zup.proposta.domain.repositories.BloqueioRepository;
import br.com.zup.proposta.microservices.contas.services.BloquearCartaoMicroService;

@Service
public class BloquearCartaoService {

	private final Logger logger = LoggerFactory.getLogger(BloquearCartaoService.class);

	@Autowired
	private BloqueioRepository bloqueioRepository;

	@Autowired
	private BloquearCartaoMicroService bloquearCartaoMicroService;

	@Transactional
	public Bloqueio registrar(@NotNull Bloqueio bloqueio) {

		Integer quantidadeDeBloqueios = bloqueio.getCartao().quantidadeDeBloqueios();

		if (quantidadeDeBloqueios > 0) {
			throw new IllegalStateException("Esse cartão já foi bloqueado!");
		}

		String resultado = bloquearCartaoMicroService.registrarBloqueio(bloqueio);

		logger.info("O resultado é {}", resultado);

		if (resultado.equals("{\"resultado\":\"BLOQUEADO\"}")) {
			return bloqueioRepository.save(bloqueio);
		}

		throw new IllegalStateException("O sistema legado negou seu bloqueio!");

	}

}
