package br.com.zup.proposta.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class RecuperarSenhaCartao {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@NotNull
	@ManyToOne
	private Cartao cartao;

	private LocalDateTime momentoSolicitado;

	@NotEmpty
	private String ipCliente;

	@NotEmpty
	private String userAgent;

	RecuperarSenhaCartao() {
		this.momentoSolicitado = LocalDateTime.now();
	}

	public RecuperarSenhaCartao(@NotNull Cartao cartao, @NotEmpty String ipCliente, @NotEmpty String userAgent) {
		this();
		this.cartao = cartao;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public LocalDateTime getMomentoSolicitado() {
		return momentoSolicitado;
	}

	public void setMomentoSolicitado(LocalDateTime momentoSolicitado) {
		this.momentoSolicitado = momentoSolicitado;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

}
