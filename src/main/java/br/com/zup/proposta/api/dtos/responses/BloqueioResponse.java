package br.com.zup.proposta.api.dtos.responses;

import java.time.LocalDateTime;

import br.com.zup.proposta.domain.models.Bloqueio;

public class BloqueioResponse {

	private String id;
	private LocalDateTime bloqueadoEm;
	private String sistemaResponsavel;
	private Boolean ativo;
	private String enderecoIp;
	private String userAgent;
	private String idCartao;

	public BloqueioResponse(Bloqueio bloqueio) {

		this.id = bloqueio.getId();
		this.bloqueadoEm = bloqueio.getBloqueadoEm();
		this.sistemaResponsavel = bloqueio.getSistemaResponsavel();
		this.ativo = bloqueio.getAtivo();
		this.enderecoIp = bloqueio.getEnderecoIp();
		this.userAgent = bloqueio.getUserAgent();
		this.idCartao = bloqueio.getCartao().getId();
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

	public String getIdCartao() {
		return idCartao;
	}

}
