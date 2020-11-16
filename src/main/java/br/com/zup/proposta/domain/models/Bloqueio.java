package br.com.zup.proposta.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Bloqueio {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	private LocalDateTime bloqueadoEm;
	private String sistemaResponsavel;
	private Boolean ativo;
	private String enderecoIp;
	private String userAgent;

	@ManyToOne
	private Cartao cartao;

	Bloqueio() {
	}

	public Bloqueio(String enderecoIp, String userAgent, Cartao cartao) {
		this.bloqueadoEm = LocalDateTime.now();
		this.ativo = true;
		this.enderecoIp = enderecoIp;
		this.userAgent = userAgent;
		this.cartao = cartao;
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

	public String getEnderecoIp() {
		return enderecoIp;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public Cartao getCartao() {
		return cartao;
	}

}
