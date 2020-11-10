package br.com.zup.proposta.microservices.contas.dtos.responses;

import java.time.LocalDateTime;

public class VencimentoResponse {

	private String id;
	private Integer dia;
	private LocalDateTime dataDeCriacao;

	public VencimentoResponse(String id, Integer dia, LocalDateTime dataDeCriacao) {
		this.id = id;
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
	}

	public String getId() {
		return id;
	}

	public Integer getDia() {
		return dia;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

}
