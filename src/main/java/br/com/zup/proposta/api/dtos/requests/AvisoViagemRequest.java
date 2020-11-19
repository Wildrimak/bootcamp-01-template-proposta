package br.com.zup.proposta.api.dtos.requests;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import br.com.zup.proposta.domain.models.Aviso;

public class AvisoViagemRequest {

	@NotEmpty
	private String destino;

	@FutureOrPresent
	private LocalDate dataTermino;

	public AvisoViagemRequest(@NotEmpty String destino, @FutureOrPresent LocalDate dataTermino) {

		this.destino = destino;
		this.dataTermino = dataTermino;
	}

	public Aviso toModel(String ipCliente, String userAgent) {
		return new Aviso(dataTermino, destino, ipCliente, userAgent);
	}

}
