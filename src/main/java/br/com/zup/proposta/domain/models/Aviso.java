package br.com.zup.proposta.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "aviso_viagem")
public class Aviso {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	private LocalDate validoAte;

	@NotEmpty
	private String destino;

	private LocalDateTime dataAviso;

	private String ipUsuario;

	private String userAgent;

	@ManyToOne
	private Cartao cartao;

	Aviso() {
	}

	public Aviso(LocalDate validoAte, @NotEmpty String destino) {
		this.validoAte = validoAte;
		this.destino = destino;
	}

	public Aviso(LocalDate validoAte, @NotEmpty String destino, String ipUsuario, String userAgent) {
		this.validoAte = validoAte;
		this.destino = destino;
		this.dataAviso = LocalDateTime.now();
		this.ipUsuario = ipUsuario;
		this.userAgent = userAgent;
	}

	public String getId() {
		return id;
	}

	public LocalDate getValidoAte() {
		return validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDateTime getDataAviso() {
		return dataAviso;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
