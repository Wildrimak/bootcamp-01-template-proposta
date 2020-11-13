package br.com.zup.proposta.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@NotEmpty
	private String impressaoDigital;

	private LocalDateTime data;

	@ManyToOne
	private Cartao cartao;

	public Biometria() {
		this.data = LocalDateTime.now();
	}

	public Biometria(String impressaoDigital) {
		this();
		this.impressaoDigital = impressaoDigital;
	}

	public String getId() {
		return id;
	}

	public String getImpressaoDigital() {
		return impressaoDigital;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
