package br.com.zup.proposta.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cartao {

	@Id
	private String id;

	private LocalDateTime emitidoEm;
	private String titular;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Bloqueio> bloqueios;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Aviso> avisos;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Carteira> carteiras;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Parcela> parcelas;

	private BigDecimal limite;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Renegociacao renegociacao;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Vencimento vencimento;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Biometria> biometrias;

	private String idProposta;

	Cartao() {
		this.bloqueios = new ArrayList<>();
		this.avisos = new ArrayList<>();
		this.carteiras = new ArrayList<>();
		this.parcelas = new ArrayList<>();
		this.biometrias = new ArrayList<>();
	}

	public Cartao(String id, LocalDateTime emitidoEm, String titular, @NotNull List<Bloqueio> bloqueios,
			List<Aviso> avisos, List<Carteira> carteiras, List<Parcela> parcelas, BigDecimal limite,
			Renegociacao renegociacao, Vencimento vencimento, String idProposta) {

		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueios = bloqueios;
		this.avisos = avisos;
		this.carteiras = carteiras;
		this.parcelas = parcelas;
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public List<Bloqueio> getBloqueios() {
		return bloqueios;
	}

	public List<Aviso> getAvisos() {
		return avisos;
	}

	public List<Carteira> getCarteiras() {
		return carteiras;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public Renegociacao getRenegociacao() {
		return renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public Integer quantidadeDeBloqueios() {
		return bloqueios.size();
	}

}
