package br.com.zup.proposta.domain.services;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.domain.models.StatusProposta;
import br.com.zup.proposta.domain.repositories.PropostaRepository;
import br.com.zup.proposta.microservices.analisefinanceira.services.AnaliseFinanceiraMicroService;

@Service
public class CadastrarPropostaService {

	private final Logger logger = LoggerFactory.getLogger(CadastrarPropostaService.class);

	@Autowired
	private PropostaRepository propostaRepository; // 1

	@Autowired
	private AnaliseFinanceiraMicroService analiseFinanceiraMicroService; // 1

	@Autowired
	private SolicitarCartaoEmSegundoPlanoService solicitarCartaoEmSegundoPlanoService; // 1

	@Transactional
	public Proposta salvarPropostaRecebidaSemAnalise(Proposta proposta) { // 1

		Optional<Proposta> optionalProposta = propostaRepository.findByDocumento(proposta.getDocumento());

		if (optionalProposta.isPresent()) { // 1
			throw new IllegalStateException("Esse documento já foi cadastrado!");
		}

		return propostaRepository.save(proposta);

	}

	public Proposta avaliarElegibilidade(@NotNull @Valid Proposta proposta) {

		logger.info("Avaliando Elegibilidade da proposta recebida");
		logger.info("Dados da proposta:\n\tid = {}", proposta.getId());

		// 1
		StatusProposta statusProposta = analiseFinanceiraMicroService.avaliaElegibilidade(proposta);
		proposta.setStatusProposta(statusProposta);

		logger.info("Proposta agora tem um status");
		logger.info("Dados da proposta:\n\tid = {}\n\tstatus", proposta.getId(), proposta.getStatusProposta());

		// 1
		if (statusProposta.equals(StatusProposta.ELEGIVEL)) {

			logger.info("Proposta agora está sendo enviada para ser processada em segundo plano");
			logger.info("Estado do objeto proposta: {} ", proposta);

			solicitarCartaoEmSegundoPlanoService.executar(proposta);

		}

		return proposta;
	}

	@Transactional
	public Proposta atualizarPropostaComAnalise(Proposta avaliada) {
		return propostaRepository.save(avaliada);
	}

}
