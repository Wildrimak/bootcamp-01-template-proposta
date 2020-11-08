package br.com.zup.proposta.microservices.avaliacaofinanceira.endpoints;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.proposta.microservices.avaliacaofinanceira.dtos.requests.DocumentoParaAnaliseFinanceiraRequest;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface AnaliseFinanceiraEndpoint {

	@PostMapping("/api/solicitacao") // 1
	public String avalia(DocumentoParaAnaliseFinanceiraRequest documentoParaAnaliseFinanceiraRequest);
}
