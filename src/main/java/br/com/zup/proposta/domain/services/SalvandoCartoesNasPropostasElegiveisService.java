package br.com.zup.proposta.domain.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Cartao;
import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.domain.models.StatusProposta;
import br.com.zup.proposta.domain.repositories.CartaoRepository;
import br.com.zup.proposta.domain.repositories.PropostaRepository;
import br.com.zup.proposta.microservices.contas.services.ObterCartaoMicroService;

@Service
public class SalvandoCartoesNasPropostasElegiveisService {

	private final Logger logger = LoggerFactory.getLogger(SalvandoCartoesNasPropostasElegiveisService.class);

	@Autowired
	private ObterCartaoMicroService obterCartaoMicroService; // 1

	@Autowired
	private PropostaRepository propostaRepository; // 1
	
	@Autowired
	private CartaoRepository cartaoRepository; // 1

	@Scheduled(fixedDelayString = "${periodicidade.buscar-cartao-e-salvar}")
	@Transactional
	public void executar() {

		logger.info("Iniciando execução assincrona para salvar cartoes nas propostas elegiveis");

		// 1
		List<Proposta> propostaAptasParaCartao = propostaRepository
				.findByNumeroDoCartaoIsNullAndStatusPropostaIs(StatusProposta.ELEGIVEL); // 1

		logger.info("Quantidade de propostas aptas a terem cartão: {}", propostaAptasParaCartao.size());

		propostaAptasParaCartao.forEach(proposta -> { // 1

			Optional<Cartao> optionalCartao = obterCartaoMicroService.obterCartao(proposta.getId());

			if (optionalCartao.isPresent()) { // 1

				proposta.setNumeroCartao(optionalCartao.get().getId());
				propostaRepository.save(proposta);

				logger.info("Numero do cartao foi salvo na proposta");

				cartaoRepository.save(optionalCartao.get());
				
				logger.info("Cartão salvo na minha base de dados");

				
			}


		});

	}

}
