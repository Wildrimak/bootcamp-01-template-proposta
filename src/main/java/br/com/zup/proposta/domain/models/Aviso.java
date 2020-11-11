package br.com.zup.proposta.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aviso {

	@Id
	private String id;
	private LocalDateTime validoAte;
	private String destino;

	@ManyToOne
	private Cartao cartao;

	Aviso() {
	}

	public Aviso(LocalDateTime validoAte, String destino) {
		this.validoAte = validoAte;
		this.destino = destino;
	}

	public LocalDateTime getValidoAte() {
		return validoAte;
	}

	public String getDestino() {
		return destino;
	}

}
