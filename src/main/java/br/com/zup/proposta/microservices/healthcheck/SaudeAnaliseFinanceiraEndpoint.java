package br.com.zup.proposta.microservices.healthcheck;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${feign.saude_analise_de_credito}" , url = "${feign.url_analise_de_credito}")
public interface SaudeAnaliseFinanceiraEndpoint {

	@GetMapping("/actuator/health")
	public String getStatus();

}

