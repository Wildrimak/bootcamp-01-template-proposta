package br.com.zup.proposta.microservices.contas.dtos.requests;

import javax.validation.constraints.NotEmpty;

public class BloquearCartaoBodyRequest {

	@NotEmpty
	private String sistemaResponsavel;

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public void setSistemaResponsavel(String sistemaResponsavel) {
		this.sistemaResponsavel = sistemaResponsavel;
	}

}
