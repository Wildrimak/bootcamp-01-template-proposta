package br.com.zup.proposta.microservices.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MicroServicesCheck implements HealthIndicator {

	@Autowired
	private SaudeAnaliseFinanceiraEndpoint saudeAnaliseFinanceiraEndpoint; // 1

	@Autowired
	private SaudeContasEndpoint saudeContasEndpoint; // 1

	@Override
	public Health health() {

		try { // 1

			saudeContasEndpoint.getStatus();
			saudeAnaliseFinanceiraEndpoint.getStatus();

			return Health.status(Status.UP).build();

		} catch (Exception e) { // 1
			return Health.status(Status.DOWN).build();
		}

	}

}
