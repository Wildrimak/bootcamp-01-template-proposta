package br.com.zup.proposta.api.dtos.responses;

import java.time.LocalDateTime;

import br.com.zup.proposta.domain.models.Biometria;

public class BiometriaResponse {

	private String fingeprint;
	private LocalDateTime dataCadastro;

	public BiometriaResponse(Biometria biometria) {
		this.fingeprint = biometria.getImpressaoDigital();
		this.dataCadastro = biometria.getData();
	}

	public String getFingeprint() {
		return fingeprint;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

}
