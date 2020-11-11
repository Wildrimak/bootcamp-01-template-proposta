package br.com.zup.proposta.microservices.analisefinanceira.dtos.requests;

import javax.validation.constraints.NotEmpty;

import br.com.zup.proposta.domain.models.Proposta;

public class DocumentoParaAnaliseFinanceiraRequest {

	@NotEmpty
	private String documento;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String idProposta;

	public DocumentoParaAnaliseFinanceiraRequest(Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.idProposta = String.valueOf(proposta.getId());
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getIdProposta() {
		return idProposta;
	}

}