package br.com.zup.proposta.microservices.analisefinanceira.dtos.requests;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import br.com.zup.proposta.domain.models.Proposta;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DocumentoParaAnaliseFinanceiraRequest {

	//TODO faltando entender o porque dessa classe e porque eu deveria criar uma anotation para cpf e cnpj
	@NotEmpty
	private String documento;

	@Deprecated
	public DocumentoParaAnaliseFinanceiraRequest() {
	}

	public DocumentoParaAnaliseFinanceiraRequest(Proposta proposta) {
		this.documento = proposta.getDocumento();
	}

}