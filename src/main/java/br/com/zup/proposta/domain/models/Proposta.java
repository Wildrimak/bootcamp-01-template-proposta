package br.com.zup.proposta.domain.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String documento;

	@Email
	@NotEmpty
	private String email;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String endereco;

	@NotNull
	@Positive
	private BigDecimal salario;
	
	private String numeroDoCartao;

	@Enumerated(EnumType.STRING)
	private StatusProposta statusProposta;

	Proposta() {
	}

	public Proposta(@NotEmpty String documento, @Email @NotEmpty String email, @NotEmpty String nome,
			@NotEmpty String endereco, @NotNull @Positive BigDecimal salario) {
		this.documento = somenteNumeroDocumento(documento);
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

	public StatusProposta getStatusProposta() {
		return statusProposta;
	}

	public String getNome() {
		return nome;
	}

	public void setStatusProposta(StatusProposta statusProposta) {
		this.statusProposta = statusProposta;
	}

	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroDoCartao = numeroCartao;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	private String somenteNumeroDocumento(String documento) {
		return documento.replaceAll("[^0-9]", "");
	}

}
