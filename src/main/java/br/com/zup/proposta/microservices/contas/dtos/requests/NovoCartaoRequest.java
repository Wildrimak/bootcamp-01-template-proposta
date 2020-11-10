package br.com.zup.proposta.microservices.contas.dtos.requests;

import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.microservices.contas.services.NovoCartaoMicroService;

public class NovoCartaoRequest {

	private final Logger logger = LoggerFactory.getLogger(NovoCartaoMicroService.class);
	
	@NotEmpty
	private String documento;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String idProposta;

	public NovoCartaoRequest(Proposta proposta) {
		logger.info("Fabricando o NovoCartaoRequest para ser enviando ao microServiço no body da request");
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
