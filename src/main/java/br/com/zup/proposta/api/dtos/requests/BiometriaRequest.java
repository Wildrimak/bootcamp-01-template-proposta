package br.com.zup.proposta.api.dtos.requests;

import javax.validation.constraints.NotEmpty;

import br.com.zup.proposta.domain.models.Biometria;

public class BiometriaRequest {

	@NotEmpty
	private String fingerprint;

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	public Biometria toModel() {
		return new Biometria(fingerprint);
	}
	
}
