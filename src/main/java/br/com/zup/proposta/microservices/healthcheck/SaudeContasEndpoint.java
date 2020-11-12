package br.com.zup.proposta.microservices.healthcheck;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${feign.saude_contas}" , url = "${feign.url_obtencao_de_cartao}")
public interface SaudeContasEndpoint {

	@GetMapping("/actuator/health")
	public String getStatus();

}

	
