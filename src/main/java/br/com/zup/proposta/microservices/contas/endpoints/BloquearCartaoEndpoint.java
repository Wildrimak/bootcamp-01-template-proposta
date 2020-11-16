package br.com.zup.proposta.microservices.contas.endpoints;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.proposta.microservices.contas.dtos.requests.BloquearCartaoBodyRequest;

@FeignClient(name = "${feign.bloquear_cartao}", url = "${feign.url_bloquear_cartao}")
public interface BloquearCartaoEndpoint {

	@PostMapping("/api/cartoes/{idCartao}/bloqueios")
	public String bloquearCartao(@PathVariable("idCartao") String idCartao,
			BloquearCartaoBodyRequest bloquearCartaoBodyRequest);

}
