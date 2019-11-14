package br.ufrpe.sistema_locadora.negocio.beans;

import java.time.LocalDateTime;

public class Manutencao {
	//ATRIBUTOS
	private Reboque			reboque;
	private String			tipoServico;
	private	String			descricao;
	private	String			local;
	private LocalDateTime	dataHora;
	private double			valor;
	/**
	 * @param reboque
	 * @param tipoServico
	 * @param descricao
	 * @param local
	 * @param dataHora
	 * @param valor
	 */
	public Manutencao(Reboque reboque, String tipoServico, String descricao, String local, LocalDateTime dataHora,
			double valor) {
		super();
		this.reboque = reboque;
		this.tipoServico = tipoServico;
		this.descricao = descricao;
		this.local = local;
		this.dataHora = dataHora;
		this.valor = valor;
	}
	public Reboque getReboque() {
		return reboque;
	}
	public void setReboque(Reboque reboque) {
		this.reboque = reboque;
	}
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Manutencao [reboque=" + reboque + ", tipoServico=" + tipoServico + ", descricao=" + descricao
				+ ", local=" + local + ", dataHora=" + dataHora + ", valor=" + valor + "]";
	}
	
	
}
