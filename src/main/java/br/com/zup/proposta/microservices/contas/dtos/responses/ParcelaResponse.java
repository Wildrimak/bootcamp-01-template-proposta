package br.com.zup.proposta.microservices.contas.dtos.responses;

import java.math.BigDecimal;

public class ParcelaResponse {

	private String id;
	private Integer quantidade;
	private BigDecimal valor;

	public ParcelaResponse(String id, Integer quantidade, BigDecimal valor) {
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

}
