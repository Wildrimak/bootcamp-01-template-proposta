package br.com.zup.proposta.domain.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Parcela {

	@Id
	private String id;
	private Integer quantidade;
	private BigDecimal valor;

	@ManyToOne
	private Cartao cartao;

	Parcela() {
	}

	public Parcela(String id, Integer quantidade, BigDecimal valor) {
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
