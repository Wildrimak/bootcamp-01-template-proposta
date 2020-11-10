package br.com.zup.proposta.microservices.contas.endpoints;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.proposta.microservices.contas.dtos.requests.NovoCartaoRequest;

@FeignClient(name = "${feign.criacao_de_cartao}" , url = "${feign.url_criacao_de_cartao}")
public interface NovoCartaoEndpoint {

	@PostMapping("/api/cartoes")
	public String criarCartao(NovoCartaoRequest novoCartaoRequest);
	
}
