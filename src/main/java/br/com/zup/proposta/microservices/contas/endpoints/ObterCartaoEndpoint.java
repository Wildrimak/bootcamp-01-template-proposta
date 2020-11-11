package br.com.zup.proposta.microservices.contas.endpoints;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.zup.proposta.domain.models.Cartao;

@FeignClient(name = "${feign.obtencao_de_cartao}" , url = "${feign.url_obtencao_de_cartao}")
public interface ObterCartaoEndpoint {

	@GetMapping("/api/cartoes")
	public Cartao getCartao(@RequestParam("idProposta") Long idProposta);
	
}
