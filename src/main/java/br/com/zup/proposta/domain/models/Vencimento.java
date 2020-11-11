package br.com.zup.proposta.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vencimento {

	@Id
	private String id;
	private Integer dia;
	private LocalDateTime dataDeCriacao;

	@OneToOne(mappedBy = "vencimento")
	private Cartao cartao;

	Vencimento() {
	}

	public Vencimento(String id, Integer dia, LocalDateTime dataDeCriacao) {
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
