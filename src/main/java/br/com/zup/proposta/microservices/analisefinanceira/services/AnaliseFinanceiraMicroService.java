package br.com.zup.proposta.microservices.analisefinanceira.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.domain.models.StatusProposta;
import br.com.zup.proposta.microservices.analisefinanceira.dtos.requests.DocumentoParaAnaliseFinanceiraRequest;
import br.com.zup.proposta.microservices.analisefinanceira.endpoints.AnaliseFinanceiraEndpoint;
import feign.FeignException.UnprocessableEntity;

@Service
public class AnaliseFinanceiraMicroService {

	@Autowired
	private AnaliseFinanceiraEndpoint analiseFinanceiraEndpoint; // 1

	// 2: StatusProposta e Proposta
	public StatusProposta avaliaElegibilidade(@NotNull @Valid Proposta proposta) {

		try { // 1

			// 1
			analiseFinanceiraEndpoint.avalia(new DocumentoParaAnaliseFinanceiraRequest(proposta));

			return StatusProposta.ELEGIVEL;

		} catch (UnprocessableEntity e) {
			return StatusProposta.NAO_ELEGIVEL;
		}

	}

}
