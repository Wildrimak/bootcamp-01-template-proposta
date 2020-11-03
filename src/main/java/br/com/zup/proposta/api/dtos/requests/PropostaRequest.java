package br.com.zup.proposta.api.dtos.requests;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import br.com.zup.proposta.domain.models.Proposta;

public class PropostaRequest {

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

	public PropostaRequest(@NotEmpty String documento, @Email @NotEmpty String email, @NotEmpty String nome,
			@NotEmpty String endereco, @NotNull @Positive BigDecimal salario) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public boolean documentoValido() {

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);

	}

	public Proposta toProposta() {
		Proposta proposta = new Proposta(documento, email, nome, endereco, salario);
		return proposta;
	}

}
