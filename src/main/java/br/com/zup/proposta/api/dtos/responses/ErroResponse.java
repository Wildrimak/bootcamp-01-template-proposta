package br.com.zup.proposta.api.dtos.responses;

import java.time.LocalDateTime;

public class ErroResponse {

	private String titulo;
	private Tipo tipo;
	private String detalhes;
	private LocalDateTime momento;

	public ErroResponse(String titulo, Tipo tipo, String detalhes) {
		this.titulo = titulo;
		this.tipo = tipo;
		this.detalhes = detalhes;
		this.momento = LocalDateTime.now();
	}

	public String getTitulo() {
		return titulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public LocalDateTime	 getMomento() {
		return momento;
	}

	public static enum Tipo {
		NEGOCIO, API
	}

}
