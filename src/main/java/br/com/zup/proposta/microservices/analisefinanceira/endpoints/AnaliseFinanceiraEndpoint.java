package br.com.zup.proposta.microservices.analisefinanceira.endpoints;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.proposta.microservices.analisefinanceira.dtos.requests.DocumentoParaAnaliseFinanceiraRequest;

@FeignClient(name = "${feign.analise_de_credito}", url = "${feign.url_analise_de_credito}")
public interface AnaliseFinanceiraEndpoint {

	@PostMapping("/api/solicitacao") // 1
	public String avalia(DocumentoParaAnaliseFinanceiraRequest documentoParaAnaliseFinanceiraRequest);
}
