package br.com.zup.proposta.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bloqueio {

	@Id
	private String id;
	private LocalDateTime bloqueadoEm;
	private String sistemaResponsavel;
	private Boolean ativo;

	@ManyToOne
	private Cartao cartao;

	Bloqueio() {
	}

	public Bloqueio(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, Boolean ativo) {
		this.id = id;
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public Boolean getAtivo() {
		return ativo;
	}

}