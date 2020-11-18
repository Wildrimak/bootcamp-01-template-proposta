package br.com.zup.proposta.api.dtos.responses;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import br.com.zup.proposta.domain.models.RecuperarSenhaCartao;

public class RecuperarSenhaResponse {

	private String idCartao;
	private LocalDateTime localDateTime;
	private String ipUsuario;
	private String userAgent;

	public RecuperarSenhaResponse(@NotNull RecuperarSenhaCartao recuperarSenhaCartao) {

		this.idCartao = recuperarSenhaCartao.getCartao().getId();
		this.localDateTime = recuperarSenhaCartao.getMomentoSolicitado();
		this.ipUsuario = recuperarSenhaCartao.getIpCliente();
		this.userAgent = recuperarSenhaCartao.getUserAgent();

	}

	public String getIdCartao() {
		return idCartao;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public String getUserAgent() {
		return userAgent;
	}

}
